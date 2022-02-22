package com.example.userslist.di.components

import com.example.userslist.di.modules.RetrofitServicesModule
import dagger.Component


@Component(
    modules = [
        RetrofitServicesModule::class,
    ]
)
interface DataComponent {}