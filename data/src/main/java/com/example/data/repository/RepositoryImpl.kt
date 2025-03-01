package com.example.data.repository


import com.example.data.common.toProductList
import com.example.domain.model.ProductItem
import com.example.data.netwotk.ApiService
import com.example.domain.repository.Repository
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