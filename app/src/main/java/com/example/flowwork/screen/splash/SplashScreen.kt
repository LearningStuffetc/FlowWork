package com.example.flowwork.screen.splash

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.flowwork.util.DataState

@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navController: NavController,

) {
    Log.e("SplashScreen", "In SplashScreen")

    val state by viewModel.dbrow.collectAsStateWithLifecycle()
  /*  val state by viewModel.repository.getRowCount() // todo in Screen
        .map<_, DataState> {
            Log.e("SplashViewModel", it.toString())
            if (it > 2) { DataState.Loading.LoadFromNetwork
            } else {
                DataState.Success(
                    DataSource.NETWORK,
                    emptyList(),
                    "yay",
                )
            }
        }.stateIn(LocalLifecycleOwner.current.lifecycleScope, initialValue = DataState.Loading.LoadFromNetwork, started = SharingStarted.Lazily).collectAsStateWithLifecycle()
*/
    render(state = state, navController = navController)

/*   LaunchedEffect(true) {
       viewModel.inNonScope()
   }*/
}

@Composable
fun render(state: DataState?, navController: NavController) {
   when (state) {
       is DataState.Success -> {
           //  Toast.makeText(LocalContext.current, "succesMessage", Toast.LENGTH_LONG).show()
           Log.e("SplashScreen", "to HOME")
           navController.navigate("home")
       }
       is DataState.Loading -> {
           Log.e("SplashScreen", "TO STAY")
           Text(text = "Splash Screen")
       }
       is DataState.Error -> {
       }
       is DataState.Idle -> {
           Text(text = "Splash Screen")
       }

       else -> {
           // todo errorhandle
       }
   }
}
