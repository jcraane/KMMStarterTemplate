package com.example.kmmtest.util.formatting

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import java.text.DateFormat
import java.util.*

class AndroidLocalDateTimeFormatter(private val dateFormat: DateFormat = DateFormat.getDateTimeInstance()) : LocalDateTimeFormatter {
    override fun format(date: LocalDateTime, timeZone: TimeZone, type: LocalDateTimeFormatter.Type): String {
        val instant = date.toInstant(timeZone)
        return dateFormat.format(Date(instant.toEpochMilliseconds()))
    }
}
