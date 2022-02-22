package com.example.userslist.di.modules

import com.example.userslist.repositories.ServiceGenerator
import com.example.userslist.repositories.UsersRepositoryService
import dagger.Module
import dagger.Provides

@Module
class RetrofitServicesModule {
    @Provides
    fun usersRepositoryService(): UsersRepositoryService {
        return ServiceGenerator.createService(UsersRepositoryService::class.java)
    }
}