package com.example.userslist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.userslist.repositories.UsersRepository
import com.example.userslist.utils.PagingDataSource


class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel() {

    val users =
        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 3),
            pagingSourceFactory = { PagingDataSource(repository) })
            .flow.cachedIn(viewModelScope)

}