package com.example.composepoc.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.common.UiState

import com.example.composepoc.presentation.state.ProductListState

import com.example.domain.usecase.GetProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * ViewModel class to fetch product list
 */
@HiltViewModel
class ProductListVewModel @Inject constructor(productListUseCase: GetProductListUseCase) :
    ViewModel() {

   //Declare variables
    private val _productList = mutableStateOf(ProductListState())
    val productList: State<ProductListState> get() = _productList

    private val _password: MutableLiveData<String> = MutableLiveData("")
    val password: LiveData<String> = _password

    private val _user: MutableLiveData<String> = MutableLiveData("")
    val username: LiveData<String> = _user


    init {
        // invoke function to fetch product list
        productListUseCase.invoke().onEach {
            when (it) {
                is UiState.Loading -> {
                    _productList.value = ProductListState(isLoading = true)
                }

                is UiState.Success -> {
                    _productList.value = ProductListState(data = it.data)
                }

                is UiState.Error -> {
                    _productList.value = ProductListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    /**
     * Function to update user name /Password input box text
     */
    fun updateText(newText: String, flag: Boolean) {

        if (flag)
            _user.value = newText
        else
            _password.value = newText
    }


    /**
     * Function to validate username and password input box
     */
    fun validateInputBox(userName: String, password: String): Boolean {
        if (!userName.isEmpty() && !password.isEmpty())
            return true
        else
            return false
    }


}