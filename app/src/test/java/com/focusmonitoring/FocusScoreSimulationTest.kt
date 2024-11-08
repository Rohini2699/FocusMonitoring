package com.focusmonitoring

import com.focusmonitoring.data.repository.FocusRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

// Unit test to validate the focus score generation logic.
class FocusScoreSimulationTest {

    // Test to check if the generated focus score is within the valid range (0 to 100).
    @Test
    fun `focus score is within valid range`() = runBlocking {
        val repository = FocusRepositoryImpl()
        val score = repository.getFocusScore().value
        assertTrue("Focus score should be between 0 and 100", score in 0..100)
    }
}
