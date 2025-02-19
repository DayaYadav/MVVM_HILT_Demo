package com.example.composepoc.data.model

/**
 * Model class to declare product list attributes
 */
data class ProductListDTO(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String
)