package com.example.effective_mobile.utils

import android.content.Context
import androidx.core.content.ContextCompat.getString
import com.example.effective_mobile.R

object MonthDataSource {

    fun getMonthNames(context: Context) : Array<String> {
        return arrayOf(
            getString(context, R.string.January),
            getString(context, R.string.February),
            getString(context, R.string.March),
            getString(context, R.string.April),
            getString(context, R.string.May),
            getString(context, R.string.June),
            getString(context, R.string.July),
            getString(context, R.string.August),
            getString(context, R.string.September),
            getString(context, R.string.October),
            getString(context, R.string.November),
            getString(context, R.string.December)
        )
    }
}