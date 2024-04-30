package com.example.effective_mobile.domain

interface SharedPrefsRepository {
    suspend fun getStringFromPrefs() : String
    suspend fun saveStringInPrefs(value: String)
}