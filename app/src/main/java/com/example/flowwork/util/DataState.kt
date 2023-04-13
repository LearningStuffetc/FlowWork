package com.example.flowwork.util

import com.example.flowwork.data.database.entity.DataEntity

sealed class DataState {
    sealed class Loading : DataState() {
        object LoadFromDb : Loading()
        object LoadFromNetwork : Loading()
    }
    object Idle : DataState()
    data class Success(val dataSource: DataSource, val data: List<DataEntity>, val succesMessage: String?) :
        DataState()

    data class Error(val dataSource: DataSource, val message: String) : DataState()
}
