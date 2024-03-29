package com.example.newsapp.data.datasources.base

import com.example.newsapp.data.AppException
import com.example.newsapp.data.BackendException
import com.example.newsapp.data.ConnectionException
import com.example.newsapp.data.ParseBackendResponseException
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.io.IOException


open class BaseRetrofitSource(
    retrofitConfig: RetrofitConfig
) {

    val retrofit = retrofitConfig.retrofit
    private val moshi: Moshi = retrofitConfig.moshi
    private val errorAdapter = moshi.adapter(ErrorResponseBody::class.java)

    suspend fun <T> wrapRetrofitExceptions(block: suspend () -> T): T {
        return try {
            block()
        } catch (e: AppException) {
            throw e
            // moshi
        } catch (e: JsonDataException) {
            throw ParseBackendResponseException(e)
        } catch (e: JsonEncodingException) {
            throw ParseBackendResponseException(e)
            // retrofit
        } catch (e: HttpException) {
            throw createBackendException(e)
            // mostly retrofit
        } catch (e: IOException) {
            throw ConnectionException(e)
        }
    }

    private fun createBackendException(e: HttpException): Exception {
        return try {
            val errorBody: ErrorResponseBody = errorAdapter.fromJson(
                e.response()!!.errorBody()!!.string()
            )!!
            BackendException(e.code(), errorBody.error)
        } catch (e: Exception) {
            throw ParseBackendResponseException(e)
        }
    }

    class ErrorResponseBody(
        val error: String
    )

}