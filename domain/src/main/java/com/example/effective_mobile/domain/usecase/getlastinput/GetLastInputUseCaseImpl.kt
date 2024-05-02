package com.example.effective_mobile.domain.usecase.getlastinput

import com.example.effective_mobile.domain.repository.SharedPrefsRepository
import javax.inject.Inject

class GetLastInputUseCaseImpl @Inject constructor(
    private val sharedPrefsRepository: SharedPrefsRepository
) : GetLastInputUseCase {

    override suspend fun getLastInputFromPrefs(): String {
        return sharedPrefsRepository.getStringFromPrefs()
    }
}