package com.themoonk1d.rps

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.themoonk1d.rps.Model.GameViewModel
import com.themoonk1d.rps.ui.theme.screens.GamePlayLayout

enum class Screens{
    StartUp,
    GamePlay
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavLayout(modifier: Modifier = Modifier){
    val navController: NavHostController = rememberNavController()
    val gameViewModel : GameViewModel = viewModel()
    val uiState by gameViewModel.uiState.collectAsState()
    Scaffold {
        NavHost(
            modifier = modifier.padding(it),
            navController = navController,
            startDestination = Screens.GamePlay.name
        ){
            composable(Screens.GamePlay.name){
                GamePlayLayout()
            }
        }

    }
}