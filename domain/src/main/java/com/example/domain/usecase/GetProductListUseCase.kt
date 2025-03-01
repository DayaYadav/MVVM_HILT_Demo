package com.example.domain.usecase



import com.example.common.common.UiState
import com.example.domain.model.ProductItem
import com.example.domain.repository.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(private val repositoryImpl : Repository)  {

    operator fun invoke() : Flow<UiState<List<ProductItem>>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repositoryImpl.getProductList()))
        }catch (e : Exception){
            emit(com.example.common.common.UiState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}