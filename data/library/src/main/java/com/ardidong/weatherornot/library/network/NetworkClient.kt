package com.ardidong.weatherornot.library.network

import retrofit2.Retrofit
import kotlin.reflect.KClass

interface NetworkClient {

    suspend fun <T: Any> getInstance(clazz: KClass<T>) : KClass<T>
}