package com.example.kmmtest.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Title(text: String, modifier: Modifier = Modifier,) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h6
    )
}

@Composable
fun SubTitle(text: String, modifier: Modifier = Modifier,) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun Caption(text: String, modifier: Modifier = Modifier,) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.caption
    )
}
