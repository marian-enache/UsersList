package com.example.userslist.global

import android.app.Application

class UsersListApplication : Application() {

    companion object {
        lateinit var instance: UsersListApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        ComponentsProvider.setupComponentsProvider(this)
    }
}