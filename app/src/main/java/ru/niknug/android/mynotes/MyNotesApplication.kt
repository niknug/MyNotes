package ru.niknug.android.mynotes

import android.app.Application

class MyNotesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MyNotesRepository.initialize(this)
    }
}