package com.example.kmmtest.util.datetime

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun LocalDateTime.convert(sourceTimeZone: TimeZone, targetTimeZone: TimeZone) =
    toInstant(sourceTimeZone).toLocalDateTime(targetTimeZone)

fun LocalDateTime.toInstant(sourceTimeZone: TimeZone, targetTimeZone: TimeZone) =
    convert(sourceTimeZone, targetTimeZone).toInstant(targetTimeZone)
