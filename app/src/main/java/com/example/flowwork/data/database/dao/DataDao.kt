package com.example.flowwork.data.database.dao

import androidx.room.*
import com.example.flowwork.data.database.entity.DataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {

    @Query(
        value = """
        SELECT * FROM data_tbl
        WHERE code = :code
    """,
    )
    fun getDataEntity(code: String): Flow<DataEntity>

    @Query(value = "SELECT * FROM data_tbl")
    fun getDataEntities(): Flow<List<DataEntity>>

    @Query(
        value = """
        SELECT * FROM data_tbl
        WHERE code IN (:codes)
    """,
    )
    fun getDataEntities(codes: Set<String>): Flow<List<DataEntity>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreData(dataEntity: List<DataEntity>): List<Long>

    /**
     * Updates [entities] in the db that match the primary key, and no-ops if they don't
     */
    @Update
    suspend fun updateData(entities: List<DataEntity>)

    /**
     * Inserts or updates [entities] in the db under the specified primary keys
     */
    @Upsert
    suspend fun upsertData(entities: List<DataEntity>)

    /**
     * Deletes rows in the db matching the specified [codes]
     */
    @Query(
        value = """
            DELETE FROM data_tbl
            WHERE code in (:codes)
        """,
    )
    suspend fun deleteData(codes: List<String>)

    @Query("SELECT COUNT(*) FROM data_tbl")
    fun getCount(): Flow<Int>
}
