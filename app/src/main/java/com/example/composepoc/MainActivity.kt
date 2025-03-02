package com.example.composepoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composepoc.ui.theme.ComposePOCTheme
import com.example.demo.utilClass.NavigationStack
import com.example.domain.Utill.FireBaseAnnotable
import com.example.domain.repository.UserRepoTest
import com.example.domain.repository.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Field Injection
    @Inject
    lateinit var userRepoPass: UserRepository

    //Field Injection
    @Inject
    @FireBaseAnnotable
    lateinit var userRepoTest: UserRepoTest



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userRepoPass.saveUser("retert", "ertetet")

        userRepoTest.saveUser("Hello Daya","12345")

        setContent {
            ComposePOCTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationStack()
                }
            }
        }


    }
}
