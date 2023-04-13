package com.example.flowwork.screen.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowwork.data.repository.DataRepository
import com.example.flowwork.util.DataState
import com.example.flowwork.util.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(val repository: DataRepository) : ViewModel() {
    private val _dbrow = MutableStateFlow<DataState>(DataState.Loading.LoadFromNetwork)
    val dbrow: StateFlow<DataState> = _dbrow.asStateFlow() // todo this
    var dbrowAsVar: StateFlow<DataState>? = null // todo this

    val dbrowAsVal = repository.getRowCount()
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
        }.stateIn(viewModelScope, initialValue = DataState.Loading.LoadFromNetwork, started = SharingStarted.Lazily)

    init {
        Log.e("SplashViewModel", "init")
        inScope() // todo inscope

        dbrowAsVar = repository.getRowCount() // todo initate in init
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
            }.stateIn(viewModelScope, initialValue = DataState.Loading.LoadFromNetwork, started = SharingStarted.Lazily)
    }


    override fun onCleared() {
        Log.e("SplashViewModel", "super.onCleared()")
        super.onCleared()
    }


    fun inScope() {
        viewModelScope.launch {
            repository.getRowCount()
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
                }.stateIn(viewModelScope, initialValue = DataState.Loading.LoadFromNetwork, started = SharingStarted.Lazily).collect {
                    _dbrow.value = it
                }
        }
    }

    suspend fun inNonScope() {
        repository.getRowCount()
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
            }.stateIn(viewModelScope, initialValue = DataState.Loading.LoadFromNetwork, started = SharingStarted.Lazily).collect {
                _dbrow.value = it
            }

    }
}
