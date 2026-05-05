package com.example.shoppingapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.shoppingapp.data.Product

fun getIcon(name: String): ImageVector {
    return when (name) {
        "nike" -> Icons.Default.ShoppingCart
        "adidas" -> Icons.Default.Star
        "puma" -> Icons.Default.Favorite
        "nb" -> Icons.Default.CheckCircle
        else -> Icons.Default.ShoppingCart
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = getIcon(product.icon),
                contentDescription = product.name,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(product.name, style = MaterialTheme.typography.titleMedium)
                Text("$${product.price}", color = Color.Gray)
            }

        }
    }
}