package com.example.userslist.di.modules

import com.example.userslist.repositories.UsersNetworkingRepositoryImpl
import com.example.userslist.repositories.UsersRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideUsersRepository(
        usersNetworkingRepository: UsersNetworkingRepositoryImpl
    ): UsersRepository
}