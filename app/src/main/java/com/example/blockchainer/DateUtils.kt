package com.example.blockchainer

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    const val dd_MM_yyyy_HH_mm_ss = "dd-MM-yyyy HH:mm:ss"

    fun toDateStr(milliseconds: Long, format: String?): String {
        val date = Date(milliseconds)
        val formatter = SimpleDateFormat(format, Locale.getDefault())
        return formatter.format(date)
    }
}