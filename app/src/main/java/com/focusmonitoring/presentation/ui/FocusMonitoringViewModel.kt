package com.focusmonitoring.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.focusmonitoring.domain.usecase.GetFocusScoreUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// ViewModel responsible for handling the logic of focus monitoring and managing UI state.
class FocusMonitoringViewModel(private val getFocusScoreUseCase: GetFocusScoreUseCase) : ViewModel() {
    private val _focusScore = MutableStateFlow(0)
    val focusScore = _focusScore.asStateFlow()

    private val _isScanning = MutableStateFlow(false)
    val isScanning = _isScanning.asStateFlow()

    private val _isConnected = MutableStateFlow(false)
    val isConnected = _isConnected.asStateFlow()

    private var monitoringJob: Job? = null

    // Starts continuous focus monitoring with a 5-second interval between updates.
    fun startMonitoring() {
        if (monitoringJob?.isActive == true) return
        monitoringJob = viewModelScope.launch {
            while (true) {
                val score = getFocusScoreUseCase().value
                _focusScore.value = score
                delay(5000)
            }
        }
    }

    // Stops focus monitoring by canceling the job.
    fun stopMonitoring() {
        monitoringJob?.cancel()
        monitoringJob = null
    }

    // Simulates starting a BLE scan with a 3-second delay.
    fun startBLEScan() {
        _isScanning.value = true
        viewModelScope.launch {
            delay(3000) // Simulate scan delay.
            _isScanning.value = false
            _isConnected.value = true // Simulates successful BLE connection.
        }
    }

    // Disconnects the BLE connection.
    fun disconnectBLE() {
        _isConnected.value = false
    }
}
