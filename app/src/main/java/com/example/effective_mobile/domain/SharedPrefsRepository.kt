package com.example.effective_mobile.domain

interface SharedPrefsRepository {

    fun getStringFromPrefs() : String
    fun saveStringInPrefs(value: String)
}