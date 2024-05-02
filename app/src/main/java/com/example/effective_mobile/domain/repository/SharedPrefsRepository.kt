package com.example.effective_mobile.domain.repository

interface SharedPrefsRepository {
    suspend fun getStringFromPrefs() : String
    suspend fun saveStringInPrefs(string: String)
}