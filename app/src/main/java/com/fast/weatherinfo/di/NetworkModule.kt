package com.fast.weatherinfo.di

import com.fast.weatherinfo.api.WeatherDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesWeatherService(retrofit: Retrofit) : WeatherDataService = retrofit.create(WeatherDataService::class.java)
}