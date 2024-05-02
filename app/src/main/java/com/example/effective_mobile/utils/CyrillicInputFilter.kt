package com.example.effective_mobile.utils

import android.text.InputFilter
import android.text.Spanned

class CyrillicInputFilter : InputFilter {

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        for (i in start until end) {
            val c = source?.get(i)
            if (c != null && c != ' ' && !Character.UnicodeBlock.of(c)
                    ?.equals(Character.UnicodeBlock.CYRILLIC)!!
            ) {
                return ""
            }
        }
        return null
    }
}