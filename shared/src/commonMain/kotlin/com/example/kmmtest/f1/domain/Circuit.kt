package com.example.kmmtest.f1.domain

import com.example.kmmtest.Image
import com.example.kmmtest.Images

data class Circuit(
    val id: String,
    val name: String,
    val location: Location,
) {
    val image = Circuits.getImage(id)
}

enum class Circuits(val id: String, val image: Image) {
    BAHREIN("bahrain", Images.CIRCUIT_BAHRAIN),
    ABUDHABI("yas_marina", Images.CIRCUIT_ABUDHABI),
    ALBERTPARK("albert_park", Images.CIRCUIT_ALBERTPARK),
    BAKU("baku", Images.CIRCUIT_BAKU),
    CATALUNYA("catalunya", Images.CIRCUIT_CATALUNYA),
    HUNGARORING("hungaroring", Images.CIRCUIT_HUNGARORING),
    INTERLAGOS("interlagos", Images.CIRCUIT_INTERLAGOS),
    MEXICO("rodriguez", Images.CIRCUIT_MEXICO),
    MONACO("monaco", Images.CIRCUIT_MONACO),
    PAULRICARD("ricard", Images.CIRCUIT_PAULRICARD),
    REDBULLRING("red_bull_ring", Images.CIRCUIT_REDBULLRING),
    SILVERSTONE("silverstone", Images.CIRCUIT_SILVERSTONE),
    SUZUKA("suzuka", Images.CIRCUIT_SUZUKA),
    UNKNOWN("unknown", Images.CIRCUIT_SUZUKA);

    companion object {
        fun getImage(circuitId: String) = Circuits.values().find { it.id == circuitId }?.image ?: UNKNOWN.image
    }
}
