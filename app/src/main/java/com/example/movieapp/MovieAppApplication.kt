package com.example.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FirstAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //for crashlytics log
    }

}
