package com.josuelassey.testuser.dao

import androidx.room.Dao
import com.josuelassey.testuser.local_model.PostUser
import com.josuelassey.testuser.local_model.User

@Dao
interface Dao {

    fun getAllPostUser() : List<PostUser>

    fun getAllUser() : List<User>
}