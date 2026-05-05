package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.viewmodel.ShopViewModel
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(viewModel: ShopViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Your Cart") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            LazyColumn {
                items(viewModel.cart) { product ->
                    Text("${product.name} - $${product.price}")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Total: $${viewModel.getTotal()}",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}