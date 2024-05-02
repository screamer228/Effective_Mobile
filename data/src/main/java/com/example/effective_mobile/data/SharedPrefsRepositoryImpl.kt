package com.example.effective_mobile.data

import android.content.SharedPreferences
import com.example.data.BuildConfig
import com.example.effective_mobile.domain.repository.SharedPrefsRepository
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

    override suspend fun saveStringInPrefs(string: String) {
        with(sharedPreferences.edit()) {
            putString(BuildConfig.PREFS_TITLE_KEY, string)
            apply()
        }
    }
}