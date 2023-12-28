package com.fast.weatherinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fast.weatherinfo.data.model.WeatherDataEntity
import com.fast.weatherinfo.repository.WeatherDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class WeatherDataViewModel @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : ViewModel() {
    private val TAG = "WeatherDataViewModel::"
    private val _weatherData: MutableList<WeatherDataEntity> = mutableListOf()
    val weatherData = _weatherData
    private val _result: MutableLiveData<Boolean> = MutableLiveData(false)
    var result: LiveData<Boolean> = _result

    private var weatherFcstValue = ""

    fun requestWeatherData(
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String
    )
    = weatherDataRepository.requestWeatherData(
        pageNo,
        numOfRows,
        dataType,
        baseDate,
        baseTime,
        nx,
        ny
    )
        .onEach {
            //Timber.d("$TAG requestWeatherData() $it")
            for(i in it.response.body.items.item.indices) {
                weatherFcstValue = it.response.body.items.item[i].fcstValue

                _weatherData.add(
                    WeatherDataEntity(
                        it.response.body.items.item[i].baseDate,
                        it.response.body.items.item[i].baseTime,
                        weatherShape(it.response.body.items.item[i].category) ?: "",
                        it.response.body.items.item[i].fcstDate,
                        it.response.body.items.item[i].fcstTime,
                        weatherFcstValue,
                        it.response.body.items.item[i].nx,
                        it.response.body.items.item[i].ny
                    )
                )
            }
            _result.value = true
        }
        .catch { e -> e.printStackTrace() }
        .launchIn(viewModelScope)

    // 날씨 형태에 따른 분석(category)
    private fun weatherShape(shape: String): String? {
        var data = ""
        data = when (shape) {
            "POP" -> "강수확률"
            "R06" -> "6시간 강수량"
            "REH" -> "습도"
            "S06" -> "6시간 신적설 범주(1mm)"
            "SKY" -> "하늘상태"
            "T3H" -> "3시간 기온"
            "TMN" -> "아침 최저기온"
            "TMX" -> "낮 최고기온"
            "UUU" -> "풍속 (동서성분)"
            "VVV" -> "풍속(남북성분)"
            "PTY" -> "강수형태"
            "WAV" -> "파고"
            "VEC" -> "풍향"
            "WSD" -> "풍속"
            "TMP" -> "1시간 기온"
            "SNO" -> "1시간 신적설"
            "PCP" -> "1시간 강수량"
            else -> ""
        }
        if (data == "하늘상태")
            weatherFcstValue = skyState(weatherFcstValue) ?: ""
        else if (data == "강수형태")
            weatherFcstValue = precipitation(weatherFcstValue) ?: ""
        //Timber.d("$TAG::weatherShape() $shape, weatherFcstValue: $weatherFcstValue")
        return data
    }

    // 하늘 상태
    private fun skyState(skyData: String): String? {
        when (skyData) {
            "1" -> return "맑음"
            "3" -> return "구름맑음"
            "4" -> return "흐림"
        }
        //Timber.d("$TAG::skyState() $skyData")
        return skyData
    }

    // 강수 형태
    private fun precipitation(rainData: String): String? {
        when (rainData) {
            "0" -> return "없음"
            "1" -> return "비"
            "2" -> return "비/눈"
            "3" -> return "눈"
            "4" -> return "소나기"
            "5" -> return "빗방물"
            "6" -> return "진눈개비"
            "7" -> return "눈날림"
        }
        //Timber.d("$TAG::precipitation() $rainData")
        return rainData
    }

    // 현재시간에 따른 측정시간 값
    fun timeChange(time: String?): String? {
        // 현재 시간에 따라 데이터 시간 설정(3시간 마다 업데이트) //
        /**
         * 시간은 3시간 단위로 조회해야 한다. 안그러면 정보가 없다고 뜬다.
         * 0200, 0500, 0800 ~ 2300까지
         * 그래서 시간을 입력했을때 switch문으로 조회 가능한 시간대로 변경해주었다.
         */
        var time = time
        time = when (time) {
            "0200", "0300", "0400" -> "0200"
            "0500", "0600", "0700" -> "0500"
            "0800", "0900", "1000" -> "0800"
            "1100", "1200", "1300" -> "1100"
            "1400", "1500", "1600" -> "1400"
            "1700", "1800", "1900" -> "1700"
            "2000", "2100", "2200" -> "2000"
            else -> "2300"
        }
        return time
    }
}