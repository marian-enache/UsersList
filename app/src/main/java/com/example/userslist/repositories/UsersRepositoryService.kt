package com.example.userslist.repositories

import com.example.userslist.domain.UserModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersRepositoryService {
    @GET("/api")
    suspend fun getUsersList(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String = "abc",
    ) : Single<List<UserModel>>
}