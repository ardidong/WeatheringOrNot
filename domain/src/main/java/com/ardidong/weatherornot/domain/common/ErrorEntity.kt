package com.ardidong.weatherornot.domain.common

sealed class ErrorEntity(open val message: String) {

    class ApiResponseError(override val message: String, val errorCode: String): ErrorEntity(message)
}
