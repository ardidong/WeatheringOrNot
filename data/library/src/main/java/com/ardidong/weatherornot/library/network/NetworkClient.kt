package com.ardidong.weatherornot.library.network

import com.ardidong.weatherornot.domain.common.ResultOf
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.reflect.KClass

interface NetworkClient {

    suspend fun <T: Any> getInstance(clazz: Class<T>) : T

    suspend fun <T : Any> handleApi(execute: suspend () -> Response<T>): ResultOf<T>
}