package com.themoonk1d.rps.State

data class GameUiState(
    val score: Int = 0,
    val moves: Int = 3,
    val instruction: String = "Make A Move!",
    val user: String = "",
    val power: Int = 0
)
