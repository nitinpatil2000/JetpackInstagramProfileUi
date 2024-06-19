package com.courses.jetpackinstagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.courses.jetpackinstagramapp.ui.theme.JetpackInstagramAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackInstagramAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavBar(navHostController = navController)
                    },
                    containerColor = Color.White
                ) { paddingValues ->
                    InstagramNavGraph(navController, modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}


@Composable
fun InstagramNavGraph(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navHostController, startDestination = BottomNavRoutes.PROFILE.route) {
        composable(BottomNavRoutes.PROFILE.route) {
            ProfilePreviewScreen(modifier)
        }
        composable(BottomNavRoutes.HOME.route) {}
        composable(BottomNavRoutes.SEARCH.route) {}
        composable(BottomNavRoutes.REELS.route) {}
        composable(BottomNavRoutes.NOTIFICATION.route) {}
    }
}
