package com.example.flowwork

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class App : Application() {

    val applicationScope by lazy { CoroutineScope(SupervisorJob() + Dispatchers.IO) }
}
