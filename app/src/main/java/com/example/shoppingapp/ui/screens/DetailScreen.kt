package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.data.Product
import com.example.shoppingapp.viewmodel.ShopViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(product: Product, viewModel: ShopViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(product.name) })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(product.name, style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(12.dp))

            Text("Price: $${product.price}")

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { viewModel.addToCart(product) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add to Cart")
            }
        }
    }
}