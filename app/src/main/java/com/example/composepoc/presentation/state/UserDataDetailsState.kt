package com.example.composepoc.presentation.state

import com.example.composepoc.domain.model.UserDataResponse

data class UserDataDetailsState (
    val isLoading: Boolean = false,
    val data: UserDataResponse? = null,
    var error: String = ""
)