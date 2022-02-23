package com.example.userslist.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val GENERAL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'"

    /**
    Date format: 2021-09-27 21:00:00
     */
    fun getHourOfDayFromDate(dateString: String): String? {
        val sdf = SimpleDateFormat(GENERAL_DATE_FORMAT, Locale.US)

        val date = try {
            sdf.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
            return null
        }
        val calendar = Calendar.getInstance()
        calendar.time = date

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return "$hour:$minute"
    }

}