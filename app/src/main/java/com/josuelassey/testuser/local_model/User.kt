package com.josuelassey.testuser.local_model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "name")
    var name : Int,
    @ColumnInfo(name = "username")
    var userName : String,
    @ColumnInfo
    var address : String,
    @ColumnInfo(name = "phone")
    var phone : String,
    @ColumnInfo(name = "website")
    var website : String,
    @ColumnInfo
    var company : String
){
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}