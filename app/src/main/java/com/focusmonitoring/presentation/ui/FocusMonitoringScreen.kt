package com.focusmonitoring.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

// Composable function that represents the UI for the focus monitoring screen.
@Composable
fun FocusMonitoringScreen(viewModel: FocusMonitoringViewModel) {
    // Observing state from the ViewModel using Jetpack Compose's state handling.
    val focusScore by viewModel.focusScore.collectAsState()
    val isScanning by viewModel.isScanning.collectAsState()
    val isConnected by viewModel.isConnected.collectAsState()
    var isMonitoring by rememberSaveable { mutableStateOf(false) }

    // Main layout with vertically centered components.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        // Displays the current focus score.
        Text(text = "Focus Score: $focusScore", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Button to start or stop focus monitoring.
        Button(
            onClick = {
                isMonitoring = !isMonitoring
                if (isMonitoring) {
                    viewModel.startMonitoring()
                    Toast.makeText(context,"Monitoring Started " ,Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context,"Monitoring Stopped " ,Toast.LENGTH_SHORT).show()
                    viewModel.stopMonitoring()
                }
            }
        ) {
            Text(if (isMonitoring) "Stop Monitoring" else "Start Monitoring")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Conditional UI elements based on BLE connection state.
        if (!isConnected) {
            Button(
                onClick = { viewModel.startBLEScan() },
                enabled = !isScanning
            ) {
                Text(if (isScanning) "Scanning..." else "Start BLE Scan")
            }
        } else {
            Button(
                onClick = { viewModel.disconnectBLE() }
            ) {
                Text("Disconnect BLE")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Connected to BLE Device", color = MaterialTheme.colorScheme.primary)
        }
    }
}
