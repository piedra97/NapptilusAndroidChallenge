package com.example.napptilusandroidchallenge

import android.app.Application
import com.example.napptilusandroidchallenge.di.oompaLoompaModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class OompaLoompaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@OompaLoompaApplication)
            modules(oompaLoompaModule)
        }
    }
}
