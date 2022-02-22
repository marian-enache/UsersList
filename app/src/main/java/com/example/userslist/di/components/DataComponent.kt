package com.example.userslist.di.components

import com.example.userslist.di.modules.RetrofitServicesModule
import com.example.userslist.repositories.ServiceGenerator
import dagger.Component


@Component(
    modules = [
        RetrofitServicesModule::class,
    ]
)
interface DataComponent {
    fun inject(serviceGenerator: ServiceGenerator)
}