package dev.mobilerevolution.starter.f1.viewmodel.standings

import dev.mobilerevolution.starter.L
import dev.mobilerevolution.starter.f1.domain.DriverStandings
import dev.mobilerevolution.starter.f1.repository.F1Repository
import dev.mobilerevolution.starter.platform.SharedViewModel
import dev.mobilerevolution.starter.points
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class DriverStandingsViewModel(f1Repository: F1Repository) : SharedViewModel() {
    private val _selectedYear = MutableStateFlow(
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
    )

    private val _driverStandings = _selectedYear.flatMapConcat { year ->
        f1Repository.getDriverStandings()
    }

    val driverStandingsOutput = _driverStandings.map { dataState ->
        dataState.map { driverStandings ->
            driverStandings.mapToOutput()
        }
    }

    private fun DriverStandings.mapToOutput(): DriverStandingsOutput {
        return DriverStandingsOutput(drivers = this.entries.map { entry ->
            DriverStandingsOutput.Driver(
                fullName = "${entry.position} ${entry.driver.givenName} ${entry.driver.familyName}",
                number = entry.driver.permanentNumber,
                points = L.driverStandings.points(entry.points.toString()),
                constructorName = entry.constructor.name,
            )
        })
    }
}
