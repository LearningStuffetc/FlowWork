package com.example.flowwork.screen.home

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, onDest: () -> Unit = {}, viewModel: HomeViewModel = hiltViewModel()) {
    Log.e("HomeScreen", "In Home screen")
    Text(text = "Hello Hello")
}
