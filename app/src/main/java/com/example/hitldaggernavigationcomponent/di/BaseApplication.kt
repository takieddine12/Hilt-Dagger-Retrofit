package com.example.hitldaggernavigationcomponent.di

import android.app.Application
import dagger.android.DaggerApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
}