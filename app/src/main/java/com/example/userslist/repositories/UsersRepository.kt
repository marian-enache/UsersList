package com.example.userslist.repositories

import com.example.userslist.domain.UserModel
import io.reactivex.Single

interface UsersRepository {
    suspend fun getUsersList(page: Int): Single<List<UserModel>>
}