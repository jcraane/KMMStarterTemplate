package dev.mobilerevolution.starter.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.mobilerevolution.starter.Images
import dev.mobilerevolution.starter.R
import dev.mobilerevolution.starter.android.extensions.drawable
import dev.mobilerevolution.starter.android.ui.theme.MyApplicationTheme
import dev.mobilerevolution.starter.common.MainViewModel
import dev.mobilerevolution.starter.common.preferences.PreferencesViewModel

@Composable
fun StarterAppTopAppBar(
    onPreferencesClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(R.string.l_app_title))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp,
        actions = {
            IconButton(onClick = onPreferencesClicked) {
                Icon(
                    painter = rememberDrawablePainter(drawable = Images.IC_SETTINGS.drawable(LocalContext.current)),
                    contentDescription = null,
                    modifier = Modifier.padding(bottom = 4.dp).size(22.dp),
                )
            }
        }
    )
}

@Preview
@Composable
private fun StarterAppTopAppBarPreview() {
    MyApplicationTheme {
        StarterAppTopAppBar(onPreferencesClicked = {})
    }
}
