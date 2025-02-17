package com.example.composepoc.domain.repository

import com.example.composepoc.domain.model.ProductDetail
import com.example.composepoc.domain.model.ProductItem
import com.example.composepoc.domain.model.UserDataResponse

interface Repository {

    suspend fun getProductList() : List<ProductItem>

    suspend fun getProductDetail(id : String) : ProductDetail

    suspend fun getUserDetails() : UserDataResponse

}