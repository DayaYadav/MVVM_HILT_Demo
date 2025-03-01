package com.example.domain.repository

import com.example.domain.common.toProductList
import com.example.domain.model.ProductItem
import com.example.domain.netwotk.ApiService
import javax.inject.Inject

/**
 * Repository class file to fetch product list
 */
class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    //Override function
    override suspend fun getProductList(): List<ProductItem> {

        return apiService.getAllProductListAPI().map { it.toProductList() }
    }


}