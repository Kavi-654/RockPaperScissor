package com.example.rockpaperscissor.model

data class GameState(

    val playerName: String = "",
    val playerGender: String = "",

    val userMove: String = "",
    val computerMove: String = "",

    val userPoints: Int = 0,
    val computerPoints: Int = 0,

    val rounds: Int = 0,

    val roundResult: String = ""

)
