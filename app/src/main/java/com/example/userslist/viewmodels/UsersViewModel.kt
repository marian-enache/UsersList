package com.example.userslist.viewmodels

import androidx.lifecycle.ViewModel
import com.example.userslist.repositories.UsersRepository

class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel() {
}