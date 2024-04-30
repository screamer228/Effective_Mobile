package com.example.effective_mobile.data

import android.content.SharedPreferences
import com.example.effective_mobile.BuildConfig
import com.example.effective_mobile.domain.SharedPrefsRepository
import javax.inject.Inject

class SharedPrefsRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SharedPrefsRepository {

    override suspend fun getStringFromPrefs(): String {
        return sharedPreferences.getString(
            BuildConfig.PREFS_TITLE_KEY,
            BuildConfig.PREFS_DEFAULT_VALUE
        )
            ?: BuildConfig.PREFS_DEFAULT_VALUE
    }

    override suspend fun saveStringInPrefs(value: String) {
        with(sharedPreferences.edit()) {
            putString(BuildConfig.PREFS_TITLE_KEY, value)
            apply()
        }
    }
}