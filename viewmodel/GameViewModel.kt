package com.example.rockpaperscissor.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rockpaperscissor.model.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state: StateFlow<GameState> = _state.asStateFlow()

    fun saveProfile(name: String, gender: String) {

        _state.update {
            it.copy(
                playerName = name,
                playerGender = gender
            )
        }
    }

    fun onPlayerMove(playerMove: String) {

        val options = listOf("Rock", "Paper", "Scissors")
        val computerMove = options.random()

        val result = when {

            playerMove == computerMove -> "Draw"

            (playerMove == "Rock" && computerMove == "Scissors") ||
                    (playerMove == "Paper" && computerMove == "Rock") ||
                    (playerMove == "Scissors" && computerMove == "Paper") -> "Win"

            else -> "Loss"
        }

        updateGameState(playerMove, computerMove, result)
    }

    private fun updateGameState(
        playerMove: String,
        computerMove: String,
        result: String
    ) {

        _state.update {

            it.copy(
                userMove = playerMove,
                computerMove = computerMove,

                userPoints =
                    if (result == "Win") it.userPoints + 1 else it.userPoints,

                computerPoints =
                    if (result == "Loss") it.computerPoints + 1 else it.computerPoints,

                rounds = it.rounds + 1,

                roundResult =
                    "You: $playerMove | CPU: $computerMove → $result"
            )
        }
    }
}
