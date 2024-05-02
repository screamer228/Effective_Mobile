package com.example.effective_mobile.domain.usecase.getlastinput

interface GetLastInputUseCase {

    suspend fun getLastInputFromPrefs(): String

}