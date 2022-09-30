package com.example.kmmtest.f1.viewmodel

import com.example.kmmtest.Image

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

