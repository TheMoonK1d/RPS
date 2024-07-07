package com.themoonk1d.rps.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.themoonk1d.rps.R

@Composable
fun GameDisplay(modifier: Modifier = Modifier){
    Column {
        Image(
            painter = painterResource(id = R.drawable.rock),
            contentDescription = null,
        )
        Text(
            text = "Make a Move",
            style = MaterialTheme.typography.displayLarge
        )
        Image(painter = painterResource(id = R.drawable.paper), contentDescription = null)
    }
}