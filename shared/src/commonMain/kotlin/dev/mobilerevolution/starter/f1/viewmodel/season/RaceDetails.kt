package dev.mobilerevolution.starter.f1.viewmodel.season

import dev.mobilerevolution.starter.Image

data class RaceDetails(
    val title: String,
    val circuitName: String,
    val circuit: Image,
    val schedule: List<Entry>,
) {
    data class Entry(
        val title: String,
        val formattedTime: String,
    )
}

