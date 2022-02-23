package com.example.userslist.repositories

import com.example.userslist.domain.UsersResponse
import io.reactivex.Single

interface UsersRepository {
    fun getUsersList(page: Int): Single<UsersResponse>
}