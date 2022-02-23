package com.example.userslist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.userslist.global.Constants.RESULTS_COUNT
import com.example.userslist.repositories.UsersRepository
import com.example.userslist.utils.ErrorHandler
import com.example.userslist.utils.PagingDataSource


class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel() {

    companion object {
        private const val PREFETCH_DISTANCE = 3
    }

    fun getUsers(errorHandler: ErrorHandler) =
        Pager(config = PagingConfig(pageSize = RESULTS_COUNT, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = { PagingDataSource(repository, errorHandler) })
            .flow.cachedIn(viewModelScope)

}