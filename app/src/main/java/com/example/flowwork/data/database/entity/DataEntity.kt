package com.example.flowwork.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "data_tbl",
)
data class DataEntity(
    @PrimaryKey
    val Code: String,
    val Value: Double,

)
