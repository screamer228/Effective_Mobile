package com.example.effective_mobile.data.datahelper

import android.content.Context
import android.content.res.AssetManager

object DataSourceReader {

    fun getJsonString(context: Context, fileName: String): String {
        return context.assets.readFile(fileName)
    }

    private fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText() }
}