package com.example.shoppingapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.Product

class ShopViewModel : ViewModel() {

    val products = listOf(
        Product(1, "Nike Air Max", 137.5),
        Product(2, "Adidas Ultraboost", 120.0),
        Product(3, "Puma RS-X", 110.0),
        Product(4, "New Balance 574", 95.0)
    )

    var cart = mutableStateListOf<Product>()
        private set

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun getTotal(): Double {
        return cart.sumOf { it.price }
    }
}