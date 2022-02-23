package com.example.userslist.utils

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.example.userslist.domain.User
import com.example.userslist.domain.UsersResponse
import com.example.userslist.repositories.UsersRepository
import io.reactivex.Single

class PagingDataSource(
    private val repository: UsersRepository,
    private val errorHandler: ErrorHandler
) : RxPagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, User>> {
        // Start refresh at page 1 if undefined.
        val nextPageNumber = params.key ?: 1

        return repository.getUsersList(nextPageNumber)
            .map(this::toLoadResult)
            .onErrorReturn {
                errorHandler.handleError(it)
                LoadResult.Error(it)
            }
    }

    private fun toLoadResult(response: UsersResponse): LoadResult<Int, User> {
        return LoadResult.Page(
            response.results,
            null,// Only paging forward.
            response.getNextPageNumber(),
            LoadResult.Page.COUNT_UNDEFINED,
            LoadResult.Page.COUNT_UNDEFINED
        )
    }
}