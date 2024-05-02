package com.example.effective_mobile.domain.usecase.saveinput

import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import javax.inject.Inject

class SaveInputUseCaseImpl @Inject constructor(
    private val sharedPrefsRepository: SharedPrefsRepository
) : SaveInputUseCase {

    override suspend fun saveInputInPrefs(string: String) {
        sharedPrefsRepository.saveStringInPrefs(string)
    }
}