package com.example.domain.repository

import com.example.domain.model.ProductItem

interface Repository {
    suspend fun getProductList() : List<ProductItem>
}