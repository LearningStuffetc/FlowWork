package com.example.flowwork.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object AppScreens {
    private const val DEFAULT = "default"
    private const val SPLASH = "splash"
    private const val ONBOARD = "onboard"
    private const val HOME = "home"


    val Default = object : IScreen {
        override val name = DEFAULT

        override val arguments = emptyList<NamedNavArgument>()

        override val route = ""
    }
    val OnBoard = object : IScreen {
        override val name = ONBOARD
        override val arguments = emptyList<NamedNavArgument>()
        override val route = ONBOARD
    }

    val Splash = object : IScreen {
        override val name = SPLASH
        override val arguments = emptyList<NamedNavArgument>()
        override val route = SPLASH
    }
    val Home = object : IScreen {
        override val name = HOME
        override val arguments = emptyList<NamedNavArgument>()
        override val route = HOME
    }

}
