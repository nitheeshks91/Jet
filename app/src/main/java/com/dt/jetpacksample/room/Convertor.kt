package com.dt.jetpacksample.room

import androidx.room.TypeConverter
import com.dt.jetpacksample.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Convertor {


    @TypeConverter
    fun convertUserToString(user: User?): String? {
        user?.let {
            return Gson().toJson(user)
        }
        return null
    }

    @TypeConverter
    fun convertStringToUser(user: String?): User? {
        user?.let {
            return Gson().fromJson(user, object : TypeToken<User>() {}.type)
        }
        return null
    }

}