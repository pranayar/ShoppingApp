package com.example.shoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.shoppingapp.ui.screens.*
import com.example.shoppingapp.viewmodel.ShopViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: ShopViewModel = viewModel()
            val navController = rememberNavController()

            NavHost(navController, startDestination = "home") {

                composable("home") {
                    HomeScreen(
                        viewModel,
                        onProductClick = {
                            navController.navigate("detail/${it.id}")
                        },
                        onCartClick = {
                            navController.navigate("cart")
                        }
                    )
                }

                composable("detail/{id}") { backStack ->
                    val id = backStack.arguments?.getString("id")?.toInt()
                    val product = viewModel.products.first { it.id == id }

                    DetailScreen(product, viewModel, navController)
                }

                composable("cart") {
                    CartScreen(viewModel, navController)
                }
            }
        }
    }
}