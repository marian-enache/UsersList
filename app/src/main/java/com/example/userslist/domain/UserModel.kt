package com.example.userslist.domain

data class UserModel(
    private val name: Name,
    private val nat: String,
    private val dob: Dob,
    private val registered: Registered,
    private val picture: Picture
) {
    fun getName() = "${name.first} ${name.last}"

    fun getLocation() = nat

    fun getYearsOld() = dob.age

    fun getRegisteredAt() = registered.date

    fun getImageUrl() = picture.medium
}

data class Name(
    val first: String,
    val last: String
)

data class Dob(val age: Int)
data class Registered(val date: String)
data class Picture(val medium: String)
