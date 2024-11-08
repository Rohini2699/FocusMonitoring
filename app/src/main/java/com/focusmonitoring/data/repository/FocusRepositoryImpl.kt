package com.focusmonitoring.data.repository

import com.focusmonitoring.data.simulation.FocusScoreSimulator
import com.focusmonitoring.domain.model.FocusScore
import com.focusmonitoring.domain.respository.FocusRepository

// Implementation of the FocusRepository interface, acting as the data source for focus scores.
class FocusRepositoryImpl : FocusRepository {
    private val simulator = FocusScoreSimulator() // Instance of the simulator to generate focus scores.

    // Fetches a focus score using the simulator.
    override suspend fun getFocusScore(): FocusScore {
        return simulator.generateFocusScore()
    }
}
