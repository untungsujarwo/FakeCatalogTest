package com.untung.fakestoreapp

import android.app.Application
import com.untung.fakestoreapp.di.listProductModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FakeStoreApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FakeStoreApp)
            modules(listProductModule)
        }
    }

}