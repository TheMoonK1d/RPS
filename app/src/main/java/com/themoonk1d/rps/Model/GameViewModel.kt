package com.themoonk1d.rps.Model

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.themoonk1d.rps.R
import com.themoonk1d.rps.State.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.Math.random

class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState : StateFlow<GameUiState> = _uiState.asStateFlow()
    private var scoreCounter: Int = 0
    private var movesLeft: Int = 0

    init {
        setUp()
    }
    
    private fun setUp(){
        scoreCounter = uiState.value.score
        movesLeft = uiState.value.moves
    }

    private enum class Score{
        Win,
        Draw,
        Loss
    }

    fun setMove(userMove: Char){
        Log.d("moves", "Setting move $userMove")
        if (movesLeft == 0){
            Log.d("moves", "Moves left $movesLeft")
            _uiState.update {
                it.copy(
                    instruction = "Out of moves!"
                )
            }
        }

        else(
            score(userMove, getAiMove())
        )
    }

    private fun getAiMove(): Char{
        val moves = listOf<Char>('r','p','s','t')
        val rand = moves[(0..3).random()]
        Log.d("moves", "AI move $rand")
        return rand
    }

    private fun score(userMove: Char, aiMove: Char){
        val finalMove = "$userMove$aiMove"
        Log.d("moves", "Final Result $finalMove")
        //User First
        when (finalMove){
            "rr" -> updateScore(Score.Draw.name)
            "pp" -> updateScore(Score.Draw.name)
            "ss" -> updateScore(Score.Draw.name)
            "rp" -> updateScore(Score.Loss.name)
            "pr" -> updateScore(Score.Win.name)
            "sp" -> updateScore(Score.Win.name)
            "ps" -> updateScore(Score.Loss.name)
            "rs" -> updateScore(Score.Win.name)
            "sr" -> updateScore(Score.Loss.name)
        }
    }

    private fun updateScore(score: String) {
        when (score) {
            Score.Win.name -> {
                _uiState.update {
                    it.copy(
                        score = ++scoreCounter,
                        moves = --movesLeft,
                        instruction = "Win!!!"
                    )
                }
                Log.d("moves", "Score: $scoreCounter")
                Log.d("moves", "Move: $movesLeft")
            }
            Score.Loss.name -> {
                if (scoreCounter == 0) {
                    _uiState.update {
                        it.copy(
                            score = 0,
                            moves = --movesLeft,
                            instruction = "Loss!"
                        )
                    }
                    Log.d("moves", "Score: $scoreCounter")
                    Log.d("moves", "Move: $movesLeft")
                } else {
                    _uiState.update {
                        it.copy(
                            score = --scoreCounter,
                            moves = --movesLeft,
                            instruction = "Lose!"
                        )
                    }
                    Log.d("moves", "Score: $scoreCounter")
                    Log.d("moves", "Move: $movesLeft")
                }
            }
            else -> {
                _uiState.update {
                    it.copy(
                        instruction = "Draw !"
                    )
                }
                Log.d("moves", "Score: $scoreCounter")
                Log.d("moves", "Move: $movesLeft")
            }
        }
    }

    fun reset(){
        _uiState.update {
            it.copy(
                instruction = "Make A Move !",
                moves = 3,
                score = 0,
            )
        }
        setUp()
    }
}