package com.example.data.common

import com.example.data.model.ProductListDTO
import com.example.domain.model.ProductItem


fun ProductListDTO.toProductList() : ProductItem {
    return ProductItem(id = this.id, image= this.image, title = this.title, description= this.description)
}
