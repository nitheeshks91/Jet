package com.dt.jetpacksample.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dt.jetpacksample.model.TestObj
import com.dt.jetpacksample.room.dao.TestApiDao

@Database(entities = [TestObj::class], version = 1)

abstract class AppDb : RoomDatabase() {

    abstract fun testDao(): TestApiDao
}