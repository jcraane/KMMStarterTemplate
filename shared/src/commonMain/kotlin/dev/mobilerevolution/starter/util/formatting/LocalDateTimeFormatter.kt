package dev.mobilerevolution.starter.util.formatting

import dev.mobilerevolution.starter.util.datetime.toInstant
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

interface LocalDateTimeFormatter {
    fun format(
        date: LocalDateTime,
        sourceTimeZone: TimeZone,
        targetTimeZone: TimeZone,
        type: Type = Type.DAY_MONTH_YEAR
    ): String

    enum class Type {
        DAY_MONTH_YEAR
    }
}

/**
 * Implementation of LocalDateTimeFormatter which does the timezone conversion. Subclasses need only to implement the doFormat method
 * to format an Instant to a readable format.
 */
abstract class AbstractLocalDateTimeFormatter : LocalDateTimeFormatter {
    override fun format(
        date: LocalDateTime,
        sourceTimeZone: TimeZone,
        targetTimeZone: TimeZone,
        type: LocalDateTimeFormatter.Type
    ): String = doFormat(date.toInstant(sourceTimeZone, targetTimeZone))

    abstract fun doFormat(instant: Instant): String
}

class DefaultLocalDateTimeFormatter : LocalDateTimeFormatter {
    override fun format(
        date: LocalDateTime,
        sourceTimeZone: TimeZone,
        targetTimeZone: TimeZone,
        type: LocalDateTimeFormatter.Type
    ): String {
        return date.toString()
    }
}


