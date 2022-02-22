package com.example.userslist.di.components

import com.example.userslist.UsersFragment
import com.example.userslist.di.modules.RepositoryModule
import com.example.userslist.di.modules.RetrofitServicesModule
import com.example.userslist.di.modules.ViewModelFactoryModule
import dagger.Component


@Component(
    modules = [
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        RetrofitServicesModule::class
    ]
)
interface ViewModelComponent {
    fun inject(usersFragment: UsersFragment)
}