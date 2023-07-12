package com.ardidong.weatherornot.library.network

import com.ardidong.weatherornot.domain.common.ErrorEntity
import com.ardidong.weatherornot.domain.common.ResultOf
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.reflect.KClass

class RetrofitClient @Inject constructor(
    private val retrofit: Retrofit
) : NetworkClient {

    override suspend fun <T : Any> getInstance(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    override suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): ResultOf<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                ResultOf.Success(body)
            } else {
                ResultOf.Failure(ErrorEntity.ApiResponseError(message = response.message(), errorCode = response.code().toString()))
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            ResultOf.Failure(
                ErrorEntity.ApiResponseError(
                    message = e.message(),
                    errorCode = e.code().toString()
                )
            )
        } catch (e: Throwable) {
            e.printStackTrace()
            ResultOf.Failure(ErrorEntity.ApiResponseError(message = e.message.toString(), errorCode = ""))
        }
    }

}