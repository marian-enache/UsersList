package com.example.userslist.di.modules

import com.example.userslist.repositories.UsersRepository
import com.example.userslist.viewmodels.UsersViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideUsersViewModel(repository: UsersRepository): UsersViewModel {
        return UsersViewModel(repository)
    }
}