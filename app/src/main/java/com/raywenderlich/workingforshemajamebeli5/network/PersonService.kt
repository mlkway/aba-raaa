package com.raywenderlich.workingforshemajamebeli5.network

import com.raywenderlich.workingforshemajamebeli5.PersonSubListItem
import retrofit2.Response
import retrofit2.http.GET

interface PersonService {



    @GET("v3/d531f5f5-180d-4364-bae7-791dae87f732")
    suspend fun getPerson():Response<List<List<PersonSubListItem>>>

}