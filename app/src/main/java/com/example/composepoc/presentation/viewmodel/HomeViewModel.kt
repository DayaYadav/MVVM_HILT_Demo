package com.example.demo.ViewModelClass

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepoc.core.common.UiState
import com.example.composepoc.domain.model.UserDataResponse
import com.example.composepoc.domain.usecase.GetUserDetailUseCase
import com.example.composepoc.presentation.state.UserDataDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel file to fetch user details from the dummy API
 * Date: 14-01-2025
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val getuserDetailIs: GetUserDetailUseCase) : ViewModel() {

    var userLiveData = MutableLiveData<UserDataResponse>()

    private val _isLoading = MutableLiveData<Boolean>(false)

    val isLoading: LiveData<Boolean> = _isLoading
    private val _userData = mutableStateOf(UserDataDetailsState())
    val userDetailDataIs : State<UserDataDetailsState> get() = _userData

    fun getUserDetailAPi(){
        getuserDetailIs.invoke().onEach {
            when(it){
                is UiState.Loading->{
                    _userData.value = UserDataDetailsState(isLoading = true)
                }
                is UiState.Success->{
                    _userData.value = UserDataDetailsState(data = it.data)
                }
                is UiState.Error->{
                    _userData.value = UserDataDetailsState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }




    /**
     * Function to launch coroutine to fetch userdata
     */
    fun getUserData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
           // getUserDataDetails()
        }
    }

    /**
     * Function to call API to fetch user data from the server
     */
  /*  private fun getUserDataDetails() {
        RetrofitInstance.api.getUserData().enqueue(object : Callback<UserDataResponse> {
            override fun onResponse(
                call: Call<UserDataResponse>,
                response: Response<UserDataResponse>
            ) {
                if (response.body() != null) {
                    userLiveData.value = response.body()
                    _isLoading.postValue(false)
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }

        }
        )
    }*/
}

