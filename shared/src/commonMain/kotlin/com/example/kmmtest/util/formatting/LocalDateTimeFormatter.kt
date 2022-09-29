package com.example.kmmtest.util.formatting

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

interface LocalDateTimeFormatter {
    fun format(
        date: LocalDateTime,
        timeZone: TimeZone,
        type: Type = Type.DAY_MONTH_YEAR): String
    enum class Type {
        DAY_MONTH_YEAR
    }
}

class DefaultLocalDateTimeFormatter : LocalDateTimeFormatter {
    override fun format(date: LocalDateTime, timeZone: TimeZone, type: LocalDateTimeFormatter.Type): String {
        return date.toString()
    }
}


