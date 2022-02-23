package com.example.userslist.domain

data class UsersResponse(
    val results: List<User>,
    val info: Info
) {
    fun getNextPageNumber() = info.page + 1
}

class Info(
    val results: Int = 0,
    val page: Int = 0
)
