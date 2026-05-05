package com.example.shoppingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.viewmodel.ShopViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    viewModel: ShopViewModel,
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart") },
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
                .padding(16.dp)
        ) {

            if (viewModel.cart.isEmpty()) {

                Text(
                    text = "Your cart is empty",
                    style = MaterialTheme.typography.titleMedium
                )

            } else {

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {

                    items(viewModel.cart.entries.toList()) { entry ->

                        val product = entry.key
                        val qty = entry.value

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {

                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                Column {
                                    Text(
                                        product.name,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text("Price: $${product.price}")
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Button(
                                        onClick = {
                                            viewModel.removeFromCart(product)
                                        }
                                    ) {
                                        Text("-")
                                    }

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text("x$qty")

                                    Spacer(modifier = Modifier.width(8.dp))

                                    Button(
                                        onClick = {
                                            viewModel.addToCart(product)
                                        }
                                    ) {
                                        Text("+")
                                    }
                                }
                            }
                        }
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 10.dp))

                Text(
                    text = "Total: $${viewModel.getTotal()}",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}