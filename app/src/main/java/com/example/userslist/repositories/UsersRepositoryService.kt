package com.example.userslist.repositories

import com.example.userslist.domain.UsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersRepositoryService {
    @GET("/api")
    fun getUsersList(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String = "abc",
    ) : Single<UsersResponse>
}