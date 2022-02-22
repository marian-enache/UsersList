package com.example.userslist.di.components

import com.example.userslist.di.modules.RepositoryModule
import com.example.userslist.di.modules.RetrofitServicesModule
import com.example.userslist.di.modules.ViewModelFactoryModule
import com.example.userslist.di.modules.ViewModelModule
import dagger.Component


@Component(
    modules = [
        ViewModelModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        RetrofitServicesModule::class
    ]
)
interface ViewModelComponent