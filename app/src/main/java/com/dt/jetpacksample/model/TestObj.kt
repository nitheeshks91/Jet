package com.dt.jetpacksample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dt.jetpacksample.room.Convertor
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TestTable")
data class TestObj(
    @PrimaryKey val id: String,
    @SerializedName("created_at") var createdAt: String? = "",
    @SerializedName("width") var width: String? = "",
    @SerializedName("height") var height: String? = "",
    @SerializedName("color") var color: String? = "",
    @SerializedName("likes") var likes: Int? = 0,
    @SerializedName("liked_by_user") var likedByUser: Boolean? = false
) {
    @TypeConverters(Convertor::class)
    @SerializedName("user")
    var user: User? = null

}


data class User(
    val id: String,
    val username: String,
    val name: String, @SerializedName("profile_image") val profile: Profile? = null
)


data class Profile(val small: String? = "", val medium: String? = "", val large: String? = "")