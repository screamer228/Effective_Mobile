package com.example.effective_mobile.domain.usecase.saveinput

interface SaveInputUseCase {

    suspend fun saveInputInPrefs(string: String)

}