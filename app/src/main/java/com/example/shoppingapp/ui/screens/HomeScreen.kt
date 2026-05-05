package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.data.Product
import com.example.shoppingapp.ui.components.ProductCard
import com.example.shoppingapp.viewmodel.ShopViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ShopViewModel,
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sneaker Store") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onCartClick() }) {
                Text("🛒")
            }
        }
    ) { padding ->

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.padding(8.dp)
        ) {
            items(viewModel.products) { product ->
                ProductCard(product) {
                    onProductClick(product)
                }
            }
        }
    }
}