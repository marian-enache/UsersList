package com.example.userslist.utils

sealed class CustomThrowable: Throwable()

interface ErrorHandler {
    fun handleError(throwable: Throwable)
}

class ReachedFinalPageException: Exception()