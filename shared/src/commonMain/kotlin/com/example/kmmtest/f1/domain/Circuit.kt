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
    ABUDHABI("bahrain", Images.CIRCUIT_ABUDHABI),
    ALBERTPARK("bahrain", Images.CIRCUIT_ALBERTPARK),
    BAKU("bahrain", Images.CIRCUIT_BAKU),
    CATALUNYA("bahrain", Images.CIRCUIT_CATALUNYA),
    HUNGARORING("bahrain", Images.CIRCUIT_HUNGARORING),
    INTERLAGOS("bahrain", Images.CIRCUIT_INTERLAGOS),
    MEXICO("bahrain", Images.CIRCUIT_MEXICO),
    MONACO("bahrain", Images.CIRCUIT_MONACO),
    PAULRICARD("bahrain", Images.CIRCUIT_PAULRICARD),
    REDBULLRING("bahrain", Images.CIRCUIT_REDBULLRING),
    SILVERSTONE("bahrain", Images.CIRCUIT_SILVERSTONE),
    SUZUKA("bahrain", Images.CIRCUIT_SUZUKA),
    UNKNOWN("unknown", Images.CIRCUIT_SUZUKA);

    companion object {
        fun getImage(circuitId: String) = Circuits.values().find { it.id == circuitId }?.image ?: UNKNOWN
    }
}
