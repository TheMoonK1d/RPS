package com.themoonk1d.rps.ui.theme.commonUi

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.themoonk1d.rps.R

@Composable
fun ControlButton(
    @DrawableRes icn : Int,
    onTap : () -> Unit
){
    Button(
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
        modifier = Modifier
            .height(80.dp)
            .width(80.dp)
    ) {
        Image(
            painter = painterResource(id = icn),
            contentDescription = "Rock",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
        )
    }
}