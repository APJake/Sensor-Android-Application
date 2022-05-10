package com.apjake.mysensor.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.apjake.mysensor.sensor.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
): ViewModel() {

    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValueChangedListener { values ->
            val lux = values[0] // x, y, z
            isDark = lux < 60f
        }
    }

}