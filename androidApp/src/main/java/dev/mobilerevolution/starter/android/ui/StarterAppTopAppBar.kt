package dev.mobilerevolution.starter.android.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.mobilerevolution.starter.R

@Composable
fun StarterAppTopAppBar(modifier: Modifier = Modifier,) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(R.string.l_app_title))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
}
