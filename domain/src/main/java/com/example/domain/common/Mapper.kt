package com.example.domain.common


import com.example.domain.model.ProductItem
import com.example.domain.model.ProductListDTO


fun ProductListDTO.toProductList() : ProductItem {
    return ProductItem(id = this.id, image= this.image, title = this.title, description= this.description)
}





