package com.example.composepoc.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composepoc.presentation.screens.component.listItem
import com.example.composepoc.presentation.viewmodel.ProductListVewModel

/**
 * Composable screen to display list of products
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ListingScreen (){

    val viewModel : ProductListVewModel = hiltViewModel()
    val context  = LocalContext.current
    var result = viewModel.productList.value

   /*     Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 25.dp)
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                "Wardrobe Essentials List",
                style = MaterialTheme.typography.headlineMedium
            )
        }

    if(result.isLoading){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }

    }*/

    result.data?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 25.dp)
                        ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            "\uD83C\uDF3F   Wardrobe Essentials",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
                items(it) { item ->
                    listItem(item) { product ->
                        Toast.makeText(context, product.title, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    if(result.error.isNotEmpty()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = result.error.toString())
        }
    }

}