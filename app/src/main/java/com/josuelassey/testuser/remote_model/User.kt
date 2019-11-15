package com.josuelassey.testuser.remote_model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


class Address{
    var street : String? = null
    var suite : String? = null
    var city : String? = null
    var zipcode : String? = null

    var geo = Geo(0,0)

    class Geo(
        var lat : Int,
        var lng : Int
    )
}

class Company{
    var name : String? = null
    var catchPhrase : String? = null
    var bs : String? = null
}
data class User(
    @SerializedName("id")
    var id : Int,
    @SerializedName("name")
    var name : String,
    @SerializedName("user_name")
    var userName : String,
    @SerializedName("user_email")
    var userEmail : String,
    @SerializedName("address")
    @Embedded
    var address : Address,
    @SerializedName("phone")
    var phone : String,
    @SerializedName("website")
    var website : String,
    @SerializedName("company")
    @Embedded
    var company : Company
)