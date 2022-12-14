package dev.mobilerevolution.starter.android.modules.standings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mobilerevolution.starter.android.extensions.ToComposable
import dev.mobilerevolution.starter.android.ui.theme.Caption
import dev.mobilerevolution.starter.android.ui.theme.SubTitle
import dev.mobilerevolution.starter.android.ui.theme.Title
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsOutput
import dev.mobilerevolution.starter.f1.viewmodel.standings.DriverStandingsViewModel
import dev.mobilerevolution.starter.common.util.DataState
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun DriverStandingsScreen(
    modifier: Modifier = Modifier,
) {
    val driverStandingsViewModel: DriverStandingsViewModel = getViewModel()
    val output: DataState<DriverStandingsOutput> by driverStandingsViewModel.driverStandingsOutput
        .collectAsStateWithLifecycle(initialValue = DataState.Empty())
    DriverStandingsContent(output = output, modifier = modifier)
}

@Composable
private fun DriverStandingsContent(
    output: DataState<DriverStandingsOutput>,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        output.ToComposable { standings ->
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
            ) {
                items(standings.drivers) { driver ->
                    DriverRow(driver = driver)
                }
            }
        }
    }
}

@Composable
private fun DriverRow(driver: DriverStandingsOutput.Driver) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(top = 4.dp)) {
            Title(text = driver.fullName)
            SubTitle(text = driver.constructorName)
            Caption(text = driver.points)
            Divider(modifier = Modifier.padding(top = 8.dp))
        }
    }
}
