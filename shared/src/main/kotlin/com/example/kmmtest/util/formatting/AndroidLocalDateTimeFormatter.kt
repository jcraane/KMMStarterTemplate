package com.example.kmmtest.util.formatting

import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.text.DateFormat
import java.util.*

class AndroidLocalDateTimeFormatter(
    private val dateFormat: DateFormat = DateFormat.getDateTimeInstance(),
) : AbstractLocalDateTimeFormatter() {
    override fun doFormat(instant: Instant): String {
        return dateFormat.format(Date(instant.toEpochMilliseconds()))
    }
}
