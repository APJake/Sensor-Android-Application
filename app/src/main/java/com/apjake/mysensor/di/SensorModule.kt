package com.apjake.mysensor.di

import android.app.Application
import com.apjake.mysensor.sensor.LightSensor
import com.apjake.mysensor.sensor.MeasurableSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): MeasurableSensor{
        return LightSensor(app)
    }

}