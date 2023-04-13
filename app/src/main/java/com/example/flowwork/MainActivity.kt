package com.example.flowwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flowwork.navigation.AppScreens
import com.example.flowwork.screen.home.HomeScreen
import com.example.flowwork.screen.splash.SplashScreen
import com.example.flowwork.ui.theme.FlowWorkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowWorkTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = AppScreens.Splash.route,
                ) {
                    composable(AppScreens.Splash.route) {
                        SplashScreen(navController = navController)
                    }

                    composable(AppScreens.Home.route) {
                        HomeScreen(navController)
                    }
                }
            }
        }
    } }
