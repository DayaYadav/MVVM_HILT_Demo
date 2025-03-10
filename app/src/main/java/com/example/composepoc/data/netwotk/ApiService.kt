package com.example.composepoc.data.netwotk

import com.example.composepoc.data.model.ProductListDTO
import retrofit2.http.GET

/**
 * API interface class to declare API endpoint
 * Declare suspend function to fetch data from server
 */
interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI(): List<ProductListDTO>

}