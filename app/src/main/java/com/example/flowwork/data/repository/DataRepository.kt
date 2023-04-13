package com.example.flowwork.data.repository

import com.example.flowwork.data.database.dao.DataDao
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val dataDao: DataDao,
    applicationScope: CoroutineScope,
) {
    fun getRowCount() = dataDao.getCount()
}
