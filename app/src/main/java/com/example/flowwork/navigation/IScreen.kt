package com.example.flowwork.navigation

import androidx.navigation.NamedNavArgument

interface IScreen {
    val name: String
    val arguments: List<NamedNavArgument>
    val route: String
}
