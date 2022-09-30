package com.example.kmmtest.f1.viewmodel.standings

import com.example.kmmtest.f1.domain.DriverStandings
import com.example.kmmtest.f1.repository.F1Repository
import com.example.kmmtest.platform.SharedViewModel
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
                points = entry.points.toString(),
                constructorName = entry.constructor.name,
                )
        })
    }
}