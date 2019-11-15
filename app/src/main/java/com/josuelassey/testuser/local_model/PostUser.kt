package com.josuelassey.testuser.local_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//Define one-to-may relationShips
@Entity(tableName = "post_user",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id")
    )]
)
data class PostUser(
    @ColumnInfo(name = "user_id")
    var userId : Int,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name = "body")
    var body : String
){
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}