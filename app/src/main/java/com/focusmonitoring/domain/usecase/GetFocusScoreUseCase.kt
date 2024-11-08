package com.focusmonitoring.domain.usecase

import com.focusmonitoring.domain.model.FocusScore
import com.focusmonitoring.domain.respository.FocusRepository

// Use case class that encapsulates the logic to fetch a focus score from the repository.
class GetFocusScoreUseCase(private val repository: FocusRepository) {
    // Operator function to execute the use case.
    suspend operator fun invoke(): FocusScore {
        return repository.getFocusScore()
    }
}
