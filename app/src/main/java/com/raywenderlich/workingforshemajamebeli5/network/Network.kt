package com.raywenderlich.workingforshemajamebeli5.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {


    val apiService by lazy { createPersonService() }


    val gsonService: PersonService = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PersonService::class.java)


    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun createPersonService():PersonService{

        val retrofit = Retrofit.Builder()
        retrofit.baseUrl("https://run.mocky.io/")
        retrofit.client(
            OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
            .build()
        )
        retrofit.addConverterFactory(mochiConvertor())
        return  retrofit.build().create(PersonService::class.java)


    }



    private fun mochiConvertor() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )



}