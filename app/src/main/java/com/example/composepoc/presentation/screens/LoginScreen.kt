package com.example.composepoc.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.common.common.Constant.mMaxPasswordLen
import com.example.composepoc.R
import com.example.composepoc.presentation.viewmodel.ProductListVewModel
import com.example.demo.utilClass.CommonUtilClass
import com.example.demo.utilClass.Screen


/**
 * Login Screen Composable function
 * Date: 14-01-2025
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val mContext = LocalContext.current
    val viewModel : ProductListVewModel = hiltViewModel()
    var mPassword = viewModel.password.observeAsState()
    var mUsername = viewModel.username.observeAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(.5f),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(
                        text = stringResource(R.string.login_label)
                        ,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    OutlinedTextField(
                        value = mUsername.value.toString(),
                        onValueChange = {
                            if (!CommonUtilClass.ValidateInputString(it, mMaxPasswordLen)) {
                                Toast.makeText(
                                    mContext,
                                    "You can not enter more then $mMaxPasswordLen characters",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                viewModel.updateText(it,true)
                            }
                        },
                        label = {
                            Text(
                                text = stringResource(R.string.password_text)

                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = mPassword.value.toString(),
                        onValueChange = {
                            if (!CommonUtilClass.ValidateInputString(it, mMaxPasswordLen)) {
                                Toast.makeText(
                                    mContext,
                                    "You can not enter more then $mMaxPasswordLen characters",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                viewModel.updateText(it,false)
                            }
                        },
                        label = {
                            Text(
                                text = stringResource(R.string.password_text)

                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            ) {
                Button(
                    onClick = {
                        if (viewModel.validateInputBox(mUsername.value.toString(),mPassword.value.toString())) {
                            navController.navigate(route = Screen.ListScreen.route)
                        }else{
                            Toast.makeText(mContext, "Username and/or Password are Empty"
                                , Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0XFF0F9D58)),
                ) {
                    Text("Next", color = Color.White)
                }

            }

        }
    }
}

