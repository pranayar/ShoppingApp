package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.data.Product
import com.example.shoppingapp.ui.components.ProductCard
import com.example.shoppingapp.viewmodel.ShopViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ShopViewModel,
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sneaker Hub") })
        },
        floatingActionButton = {
            BadgedBox(
                badge = {
                    if (viewModel.cart.size > 0) {
                        Badge {
                            Text("${viewModel.cart.size}")
                        }
                    }
                }
            ) {
                FloatingActionButton(onClick = { onCartClick() }) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                }
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Discover", style = MaterialTheme.typography.headlineMedium)

            Text(
                "Find your perfect sneakers",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(viewModel.products) { product ->
                    ProductCard(product) {
                        onProductClick(product)
                    }
                }
            }
        }
    }
}