package com.example.flowwork.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flowwork.data.database.dao.DataDao
import com.example.flowwork.data.database.entity.DataEntity

@Database(
    entities = [
        DataEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}
