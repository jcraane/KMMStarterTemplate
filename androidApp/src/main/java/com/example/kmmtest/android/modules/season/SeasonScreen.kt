package com.example.kmmtest.android.modules.season

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmmtest.android.extensions.ToComposable
import com.example.kmmtest.android.ui.theme.Caption
import com.example.kmmtest.android.ui.theme.SubTitle
import com.example.kmmtest.android.ui.theme.Title
import com.example.kmmtest.f1.viewmodel.RaceViewModel
import com.example.kmmtest.f1.viewmodel.SeasonOutput
import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.util.DataState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SeasonScreen(
    seasonViewModel: SeasonViewModel,
    modifier: Modifier = Modifier,
) {
    val output: DataState<SeasonOutput> by seasonViewModel.season.collectAsStateWithLifecycle(DataState.Empty())
    SeasonScreenContent(output, modifier)
}

@Composable
private fun SeasonScreenContent(
    output: DataState<SeasonOutput>,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        output.ToComposable { season ->
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
            ) {
                items(season.races) { race ->
                    RaceRow(race)
                }
            }
        }
    }
}

@Composable
private fun RaceRow(race: RaceViewModel) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(
                remember { MutableInteractionSource() },
                rememberRipple(bounded = true),
                onClick = {},
            )
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(top = 4.dp)) {
            Title(text = race.title)
            SubTitle(text = race.subTitle)
            Caption(text = race.caption)

            Divider(modifier = Modifier.padding(top = 8.dp))
        }
    }
}
