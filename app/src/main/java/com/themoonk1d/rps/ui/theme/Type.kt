package com.themoonk1d.rps.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.themoonk1d.rps.R

// Set of Material typography styles to start with

val agent = FontFamily(
    Font(R.font.agent_reg),
)
val lucky = FontFamily(
    Font(R.font.luckiest_guy),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
    displayLarge = TextStyle(
        fontFamily = agent,
        fontSize = 40.sp,
        textAlign = TextAlign.Center
    ) ,
    displayMedium = TextStyle(
        fontFamily = agent,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    ) ,
    displaySmall = TextStyle(
    fontFamily = lucky,
    fontSize = 20.sp,
    textAlign = TextAlign.Center
)
)