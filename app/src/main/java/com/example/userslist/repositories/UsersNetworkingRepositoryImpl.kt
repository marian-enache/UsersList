package com.example.userslist.repositories

import com.example.userslist.domain.UserModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersNetworkingRepositoryImpl @Inject constructor(
    private val usersRepositoryService: UsersRepositoryService
) : UsersRepository {

    companion object {
        private const val RESULTS_COUNT = 20
    }

    override suspend fun getUsersList(page: Int): Single<List<UserModel>> {
        return usersRepositoryService.getUsersList(page, RESULTS_COUNT)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
