package com.example.dising_pattern_android.singlton

import kotlinx.coroutines.flow.MutableStateFlow


/**
                                        * Singleton
 * это порождающий паттерн проектирования, который гарантирует, что у класса есть только один экземпляр,
 * и предоставляет к нему глобальную точку доступа.
 * Задача
 *
 * Создайте класс для управления аутентификацией пользователя.
 * Используйте паттерн Singleton, чтобы гарантировать единственный экземпляр класса аутентификации.
 *
 * Условия:
 *
 * - Класс должен предоставлять методы для входа и выхода пользователя.
 * - Класс должен хранить информацию о текущем аутентифицированном пользователе.
 * - Класс должен поддерживать проверку токена для определения, авторизован ли пользователь.
 **/

object UserAuthentication {

    private val usersTokens: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    private val userId: MutableList<String> = mutableListOf()

    private var firstName: String = String()

    private var lastName: String = String()

    private var password: String = String()

    fun logIn(
        userFirstName: String,
        userLastName: String,
        userPassword: String,
        userToken: String,
    ) {
        firstName = userFirstName
        lastName = userLastName
        password = userPassword

        usersTokens.tryEmit(listOf(userToken))
    }

    fun logout(token: String) {
        firstName = String()
        lastName = String()
        password = String()
        val currentToken = userId.find { it == token }
        userId.remove(currentToken)
        usersTokens.tryEmit(userId)
    }

    fun getCurrentUser(): List<String> {
        return listOf(firstName, lastName, password)
    }

    fun isUserAuthorized(token: String): Boolean {
        return usersTokens.value.contains(token)
    }
}

fun main() {
    val userAuth = UserAuthentication

    userAuth.logIn(
        userFirstName = "Shokh",
        userLastName = "Kadyrov",
        userPassword = "12345678",
        userToken = "12345678",
    )


    val isUserAuthorized = userAuth.isUserAuthorized("12345678")

    val userAuthText = if (isUserAuthorized) "User is Signed"
    else "User is not Signed"

    userAuth.logout(token = "12345678")

    println(userAuthText)
}