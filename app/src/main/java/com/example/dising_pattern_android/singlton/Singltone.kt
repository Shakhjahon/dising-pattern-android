package com.example.dising_pattern_android.singlton

class User {

    private var userName: String = "UserName"

    fun setNewUserName(newValue: String) {
        userName = newValue
    }

    fun getCurrentUserName(): String {
        return userName
    }
}

object ObjectUser {

    private var userName: String = "userName"

    fun setNewUserName(newValue: String) {
        userName = newValue
    }

    fun getCurrentUserName(): String {
        return userName
    }
}

fun main() {
    val objectUser = ObjectUser

    val user = User()

    objectUser.setNewUserName("New Value [Object]")

    println(objectUser.getCurrentUserName())

    user.setNewUserName("New Value [Class]")

    println(user.getCurrentUserName())
}