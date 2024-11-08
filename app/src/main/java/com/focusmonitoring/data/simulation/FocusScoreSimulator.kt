package com.focusmonitoring.data.simulation

import com.focusmonitoring.domain.model.FocusScore
import kotlinx.coroutines.delay
import kotlin.random.Random

// Class responsible for simulating the generation of a focus score.
class FocusScoreSimulator {

    // Function to generate a simulated focus score with a delay to mimic real-world behavior.
    suspend fun generateFocusScore(): FocusScore {
        delay(5000) // Simulates network or processing delay of 5 seconds.
        return FocusScore(Random.nextInt(0, 101)) // Generates a random focus score between 0 and 100.
    }
}
