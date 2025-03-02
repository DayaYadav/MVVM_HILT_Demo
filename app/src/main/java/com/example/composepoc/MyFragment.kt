package com.example.composepoc

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.domain.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyFragment : Fragment() {

    @Inject
    lateinit var xx:UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        xx.saveUser("dd","dd apssword")

    }

}