package com.example.kmmtest.android.modules.season

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.kmmtest.android.extensions.ToComposable
import com.example.kmmtest.android.extensions.drawable
import com.example.kmmtest.android.ui.theme.SubTitle
import com.example.kmmtest.android.ui.theme.Title
import com.example.kmmtest.f1.viewmodel.RaceDetails
import com.example.kmmtest.f1.viewmodel.SeasonViewModel
import com.example.kmmtest.util.DataState
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RaceScreen(
    seasonViewModel: SeasonViewModel,
    navController: NavHostController,
    raceId: String,
    modifier: Modifier = Modifier,
) {
    val output by seasonViewModel.selectedSeasonOutput.collectAsStateWithLifecycle(DataState.Empty())
    seasonViewModel.selectRace(raceId)

    RaceScreenContent(output, modifier)
}

@Composable
private fun RaceScreenContent(
    output: DataState<RaceDetails>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        output.ToComposable { raceDetails ->
            Title(raceDetails.title)
            Spacer(Modifier.height(20.dp))

            Image(
                modifier = Modifier.height(200.dp),
                painter = rememberDrawablePainter(raceDetails.circuit.drawable(LocalContext.current)),
                contentDescription = null,
            )
            Spacer(Modifier.height(20.dp))

            SubTitle(raceDetails.circuitName)
        }
    }
}
