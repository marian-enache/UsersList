package com.example.userslist.repositories

import com.example.userslist.domain.UsersResponse
import com.example.userslist.global.Constants.RESULTS_COUNT
import com.example.userslist.utils.ReachedFinalPageException
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersNetworkingRepositoryImpl @Inject constructor(
    private val usersRepositoryService: UsersRepositoryService
) : UsersRepository {

    companion object {
        private const val MAXIMUM_PAGES = 3
    }

    override fun getUsersList(page: Int): Single<UsersResponse> {
        return when {
            page <= MAXIMUM_PAGES -> usersRepositoryService.getUsersList(page, RESULTS_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
            else -> Single.error(ReachedFinalPageException())
        }
    }
}
