package com.mike.tennisnotes

import android.app.Application
import timber.log.Timber

class TennisNoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}