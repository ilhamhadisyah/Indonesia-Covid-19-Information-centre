package com.ilham.masive

import android.app.Application
import com.ilham.masive.di.AppComponent
import com.ilham.masive.di.DaggerAppComponent

class ApplicationBase : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}