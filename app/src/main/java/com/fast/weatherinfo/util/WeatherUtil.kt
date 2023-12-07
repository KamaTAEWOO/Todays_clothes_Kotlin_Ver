package com.fast.weatherinfo.util

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import java.text.SimpleDateFormat

object WeatherUtil {

    private val TAG = "@@EduforallUtil"

    private const val SHARED_PREFS_NAME = "weatherinfo_app_shared_prefs"
    private const val LOGIN_KEY = "login_result"

    /**
     ** 날짜 format 변경
     */
    fun convertDateFormat(inputDate: String): String {
        val inputDateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val outputDateFormat = SimpleDateFormat("yyyy-MM-dd")

        return outputDateFormat.format(inputDateFormat.parse(inputDate))
    }

    /**
     ** Data 저장
     */
    fun saveSharedPreferenceData(context: Context, accessToken: String) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(LOGIN_KEY, accessToken)
        editor.apply()
    }

    /**
     ** Data 가져오기
     */
    fun loadSharedPreferenceData(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(LOGIN_KEY, null)
    }

    /**
     ** Data 삭제
     */
    fun clearAccessToken(context: Context) {
        val sharedPreferences =
            context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(LOGIN_KEY).apply()
    }

    /**
     * 인터넷 연결 유무
     * */
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo ?: return false

        return activeNetwork.isConnected
    }
}



















