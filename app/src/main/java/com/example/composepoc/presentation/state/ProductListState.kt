package com.example.composepoc.presentation.state

import com.example.domain.model.ProductItem


data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductItem>? = null,
    var error: String = ""
)
