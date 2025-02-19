package com.example.composepoc.data.netwotk

import com.example.composepoc.data.model.ProductListDTO
import com.example.composepoc.domain.model.UserDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API interface class to declare API endpoint
 * Declare suspend function to fetch data from server
 */
interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI() : List<ProductListDTO>

    @GET("/products/{Id}")
    suspend fun getProductDetailsAPI(@Path("Id") id : String) : ProductListDTO



}