package dev.mobilerevolution.starter.android.modules.standings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmmtest.android.extensions.ToComposable
import com.example.kmmtest.android.ui.theme.Caption
import com.example.kmmtest.android.ui.theme.SubTitle
import com.example.kmmtest.android.ui.theme.Title
import com.example.kmmtest.f1.viewmodel.standings.DriverStandingsOutput
import com.example.kmmtest.f1.viewmodel.standings.DriverStandingsViewModel
import com.example.kmmtest.util.DataState

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun DriverStandingsScreen(
    driverStandingsViewModel: DriverStandingsViewModel,
    modifier: Modifier = Modifier,
) {
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
