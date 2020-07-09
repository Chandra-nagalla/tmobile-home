package com.example.tmobile.service

import com.example.tmobile.model.TMobileHomePages
import retrofit2.Response
import retrofit2.http.GET

interface TMobileHomeService {

    @GET("/test/home")
   suspend fun getPages(): Response<TMobileHomePages>

}