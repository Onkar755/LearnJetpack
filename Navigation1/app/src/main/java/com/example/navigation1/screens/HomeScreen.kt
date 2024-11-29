package com.example.navigation1.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation1.navigation.AUTHENTICATION_ROUTE
import com.example.navigation1.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.passNameAndId(id = 23))
            },
            text = "Home",
            color = Color.Black,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable {
                    navController.navigate(route = AUTHENTICATION_ROUTE)
                },
            text = "Login/Sign Up",
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}