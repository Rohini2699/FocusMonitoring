package com.focusmonitoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.focusmonitoring.data.repository.FocusRepositoryImpl
import com.focusmonitoring.di.AppModule
import com.focusmonitoring.domain.usecase.GetFocusScoreUseCase
import com.focusmonitoring.presentation.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use AppModule to provide the ViewModel instance.
        val focusViewModel = AppModule.provideFocusMonitoringViewModel()

        setContent {
            // Sets the content to the FocusMonitoringScreen Composable.
            FocusMonitoringScreen(focusViewModel)
        }
    }
}
