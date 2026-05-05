package com.example.shoppingapp.viewmodel

import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.Product

class ShopViewModel : ViewModel() {

    val products = listOf(
        Product(1, "Nike Air Max", 137.5, "nike"),
        Product(2, "Adidas Ultraboost", 120.0, "adidas"),
        Product(3, "Puma RS-X", 110.0, "puma"),
        Product(4, "New Balance 574", 95.0, "nb")
    )

    // 🔥 quantity-based cart
    var cart = mutableStateMapOf<Product, Int>()
        private set

    fun addToCart(product: Product) {
        cart[product] = (cart[product] ?: 0) + 1
    }

    fun removeFromCart(product: Product) {
        val current = cart[product] ?: 0
        if (current > 1) {
            cart[product] = current - 1
        } else {
            cart.remove(product)
        }
    }

    fun getTotal(): Double {
        return cart.entries.sumOf { it.key.price * it.value }
    }

    fun getTotalItems(): Int {
        return cart.values.sum()
    }

    fun getQuantity(product: Product): Int {
        return cart[product] ?: 0
    }
}