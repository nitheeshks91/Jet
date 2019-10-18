package com.dt.jetpacksample.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dt.jetpacksample.model.TestObj


@Dao
interface TestApiDao {

    @Query("SELECT * FROM TestTable")
    fun getTestListLiveData(): LiveData<List<TestObj>>

    @Query("SELECT * FROM TestTable")
    fun getTestListLive(): List<TestObj>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTestList(list: List<TestObj>)

    @Query("DELETE FROM TestTable")
    fun deleteAll()
}