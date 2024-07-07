package com.themoonk1d.rps.ui.theme.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.themoonk1d.rps.Model.GameViewModel
import com.themoonk1d.rps.R
import com.themoonk1d.rps.State.GameUiState
import com.themoonk1d.rps.ui.theme.commonUi.ControlButton


enum class Moves {
    Rock,
    Paper,
    Scissor,
    Thunder
}
@Composable
fun GamePlayLayout(
    modifier: Modifier = Modifier
){
    val gameViewModel : GameViewModel = viewModel()
    val uiState by gameViewModel.uiState.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ScoreLayout(uiState = uiState)
        Instructions(uiState = uiState)
        GameControllers(
            gameViewModel = gameViewModel
        )
    }
}

@Composable
fun ScoreLayout(
    modifier: Modifier = Modifier,
    uiState: GameUiState
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(
                top = 20.dp,
                start = 16.dp,
                end = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(R.string.score) + uiState.score,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = stringResource(R.string.moves, uiState.moves) ,
            modifier = Modifier.padding(end = 16.dp),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun Instructions(
    modifier: Modifier = Modifier,
    uiState: GameUiState
){
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse),
        label = "scale"
    )

    Box(modifier = Modifier.height(400.dp)) {
        Text(
            text = uiState.instruction,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    transformOrigin = TransformOrigin.Center
                }
                .align(Alignment.Center),
            style = MaterialTheme.typography.displayLarge.copy(
                textMotion = TextMotion.Animated,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }

}

@Composable
fun GameControllers(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel
    ){
    Column(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       ControlButton(
           icn = R.drawable.paper,
           onTap = {gameViewModel.setMove(Moves.Paper.name.first().lowercaseChar())}
       )
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            ControlButton(
                icn = R.drawable.rock,
                onTap = {gameViewModel.setMove(Moves.Rock.name.first().lowercaseChar())}
            )
            ControlButton(
                icn = R.drawable.scissor,
                onTap = {gameViewModel.setMove(Moves.Scissor.name.first().lowercaseChar())}
            )
        }
        ControlButton(
            icn = R.drawable.thunder,
            onTap = {
                gameViewModel.reset()
            }
        )
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center

        ) {
            Row (
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                Text(
                    text = "👺: Unknown",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(text = "PWR: 0", style = MaterialTheme.typography.displaySmall)
            }
        }
    }
}

@Preview
@Composable
fun GamePlayLayoutPreview(){
    GamePlayLayout()
}
