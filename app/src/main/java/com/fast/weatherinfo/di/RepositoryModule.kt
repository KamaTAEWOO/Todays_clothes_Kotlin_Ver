package com.fast.weatherinfo.di

import com.fast.weatherinfo.repository.WeatherDataRepository
import com.fast.weatherinfo.repository.WeatherDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsWeatherDataRepository(
        weatherDataRepositoryImpl: WeatherDataRepositoryImpl
    ): WeatherDataRepository
}