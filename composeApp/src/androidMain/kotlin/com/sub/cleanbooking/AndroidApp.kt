package com.sub.cleanbooking

import android.app.Application

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}