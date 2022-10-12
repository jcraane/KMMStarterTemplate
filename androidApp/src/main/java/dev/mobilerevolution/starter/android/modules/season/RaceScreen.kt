package dev.mobilerevolution.starter.android.modules.season

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mobilerevolution.starter.android.extensions.ToComposable
import dev.mobilerevolution.starter.android.extensions.drawable
import dev.mobilerevolution.starter.android.ui.theme.SubTitle
import dev.mobilerevolution.starter.android.ui.theme.Title
import dev.mobilerevolution.starter.f1.viewmodel.season.RaceDetails
import dev.mobilerevolution.starter.f1.viewmodel.season.SeasonViewModel
import dev.mobilerevolution.starter.util.DataState
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun RaceScreen(
    seasonViewModel: SeasonViewModel,
    raceId: String,
    modifier: Modifier = Modifier,
) {
    val output by seasonViewModel.selectedRaceOutput.collectAsStateWithLifecycle(DataState.Empty())
    seasonViewModel.selectRace(raceId)

    RaceScreenContent(output, modifier)
}

@Composable
private fun RaceScreenContent(
    output: DataState<RaceDetails>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(top = 16.dp).fillMaxWidth(),
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

            Spacer(Modifier.height(20.dp))
            LazyColumn {
                items(raceDetails.schedule) { entry ->
                    ScheduleEntryRow(entry)
                }
            }
        }
    }
}

@Composable
private fun ScheduleEntryRow(entry: RaceDetails.Entry) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(top = 4.dp)) {
            Title(text = entry.title)
            SubTitle(text = entry.formattedTime)
            Divider(modifier = Modifier.padding(top = 8.dp))
        }
    }
}
