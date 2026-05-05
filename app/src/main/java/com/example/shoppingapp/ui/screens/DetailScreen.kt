package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.data.Product
import com.example.shoppingapp.viewmodel.ShopViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    product: Product,
    viewModel: ShopViewModel,
    navController: NavController
) {

    val quantity = viewModel.getQuantity(product)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
        ) {

            Text(product.name, style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(10.dp))

            Text("$${product.price}", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(30.dp))

            if (quantity == 0) {

                Button(
                    onClick = { viewModel.addToCart(product) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text("Add to Bag")
                }

            } else {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(onClick = {
                        viewModel.removeFromCart(product)
                    }) {
                        Text("-")
                    }

                    Text(
                        "Quantity: $quantity",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Button(onClick = {
                        viewModel.addToCart(product)
                    }) {
                        Text("+")
                    }
                }
            }
        }
    }
}