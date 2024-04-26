package com.example.effective_mobile.app

import android.app.Application
import com.example.effective_mobile.di.AppComponent
import com.example.effective_mobile.di.AppModule
import com.example.effective_mobile.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}