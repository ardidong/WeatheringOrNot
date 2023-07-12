package com.ardidong.weatherornot.domain.common

sealed class ErrorEntity(open val message: String) {

    class ApiResponseError(override val message: String, val errorCode: String): ErrorEntity(message)

    class EmptyResultError(override val message: String): ErrorEntity(message)

    class Unknown(override val message: String): ErrorEntity(message)
}
