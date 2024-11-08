package com.focusmonitoring.domain.respository

import com.focusmonitoring.domain.model.FocusScore

// Interface defining the contract for a repository that provides focus scores.
interface FocusRepository {
    suspend fun getFocusScore(): FocusScore
}
