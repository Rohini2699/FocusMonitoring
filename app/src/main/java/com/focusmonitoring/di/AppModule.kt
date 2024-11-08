package com.focusmonitoring.di

import com.focusmonitoring.data.repository.FocusRepositoryImpl
import com.focusmonitoring.domain.respository.FocusRepository
import com.focusmonitoring.domain.usecase.GetFocusScoreUseCase
import com.focusmonitoring.presentation.ui.FocusMonitoringViewModel

// Object that acts as a simple dependency injection module to provide instances of required classes.
object AppModule {
    // Provides an instance of FocusRepository.
    private fun provideFocusRepository(): FocusRepository = FocusRepositoryImpl()

    // Provides an instance of GetFocusScoreUseCase using the repository instance.
    private fun provideGetFocusScoreUseCase(): GetFocusScoreUseCase = GetFocusScoreUseCase(provideFocusRepository())

    // Provides an instance of FocusMonitoringViewModel using the use case instance.
    fun provideFocusMonitoringViewModel(): FocusMonitoringViewModel = FocusMonitoringViewModel(provideGetFocusScoreUseCase())
}
