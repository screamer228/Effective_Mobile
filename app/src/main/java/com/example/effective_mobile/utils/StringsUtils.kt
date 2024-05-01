package com.example.effective_mobile.utils

import java.text.SimpleDateFormat
import java.util.Locale

object StringsUtils {
    fun convertDateTimeToTime(dateTimeString: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val dateTime = dateFormat.parse(dateTimeString)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return timeFormat.format(dateTime)
    }

    fun calculateFlightTime(startDateTime: String, endDateTime: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val startDate = dateFormat.parse(startDateTime)
        val endDate = dateFormat.parse(endDateTime)
        val difference = endDate.time - startDate.time

        val hours = difference / (1000 * 60 * 60)
        val minutes = (difference / (1000 * 60)) % 60
        val totalMinutes = hours * 60 + minutes
        val formattedHours = String.format("%.1f", totalMinutes / 60.0)

        return "${formattedHours}ч"
    }

    fun stringsToRow(firstString: String, secondString: String, separator: String): String {
        return firstString + separator + secondString
    }

    fun addSpaceEveryThreeDigits(input: String): String {
        val reversed = input.reversed()
        val result = StringBuilder()

        for (i in reversed.indices) {
            if (i > 0 && i % 3 == 0) {
                result.append(" ")
            }
            result.append(reversed[i])
        }

        return result.reverse().toString()
    }
}

//fun main() {
//    val startDateTime = "2024-02-23T03:15:00"
//    val endDateTime = "2024-02-24T08:30:00"
//
//    val startTime = TimeUtils.convertDateTimeToTime(startDateTime)
//    val endTime = TimeUtils.convertDateTimeToTime(endDateTime)
//
//    println("Start Time: $startTime")
//    println("End Time: $endTime")
//
//    val timeDifference = TimeUtils.calculateTimeDifference(startDateTime, endDateTime)
//    println("Time Difference: $timeDifference")
//}