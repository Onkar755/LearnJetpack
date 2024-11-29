package com.example.navigation1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation1.navigation.nav_graph.SetUpNavGraph
import com.example.navigation1.ui.theme.Navigation1Theme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation1Theme {
                navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Navigation1Theme {

    }
}