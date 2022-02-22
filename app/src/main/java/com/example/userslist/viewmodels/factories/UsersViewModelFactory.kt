package com.example.userslist.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userslist.repositories.UsersRepository
import com.example.userslist.viewmodels.UsersViewModel
import javax.inject.Inject

class UsersViewModelFactory(
    private val usersRepository: UsersRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return UsersViewModel(usersRepository) as T
    }
}