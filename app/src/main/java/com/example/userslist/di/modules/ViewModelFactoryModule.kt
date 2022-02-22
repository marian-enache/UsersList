package com.example.userslist.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.userslist.repositories.UsersRepository
import com.example.userslist.viewmodels.factories.UsersViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {
    @Provides
    fun provideUsersViewModelFactory(repository: UsersRepository): ViewModelProvider.Factory {
        return UsersViewModelFactory(repository)
    }
}