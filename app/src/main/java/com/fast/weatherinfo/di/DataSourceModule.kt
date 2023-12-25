package com.fast.weatherinfo.di

import com.fast.weatherinfo.datasource.remote.WeatherDataRemoteDataSource
import com.fast.weatherinfo.datasource.remote.WeatherDataRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsWeatherDataRemoteDataSource(
        weatherDataRemoteDataSourceImpl: WeatherDataRemoteDataSourceImpl
    ): WeatherDataRemoteDataSource

}