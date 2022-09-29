package com.example.kmmtest.android.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmstartertemplate.android.R

@Composable
@Suppress("MagicNumber")
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = colorResource(R.color.primaryDarkColor),
            primaryVariant = Color(0xFF3700B3),
            secondary = colorResource(R.color.secondaryDarkColor),
            onPrimary = colorResource(R.color.primaryTextColor),
        )
    } else {
        lightColors(
            primary = colorResource(R.color.primaryColor),
            primaryVariant = Color(0xFF3700B3),
            secondary = colorResource(R.color.secondaryColor),
            onPrimary = colorResource(R.color.primaryTextColor),
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )/*,
        h3 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp
        )*/
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
