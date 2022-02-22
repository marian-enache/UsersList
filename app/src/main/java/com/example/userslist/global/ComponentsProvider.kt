package com.example.userslist.global

import android.content.Context
import com.example.userslist.di.components.DaggerDataComponent
import com.example.userslist.di.components.DaggerViewModelComponent
import com.example.userslist.di.components.DataComponent
import com.example.userslist.di.components.ViewModelComponent


object ComponentsProvider {

    lateinit var viewModelComponent: ViewModelComponent
        private set

    lateinit var dataComponent: DataComponent
        private set

    fun setupComponentsProvider(@ApplicationContext context: Context) {
        viewModelComponent = DaggerViewModelComponent.builder().build()
        dataComponent = DaggerDataComponent.builder().build()
    }
}