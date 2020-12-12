package com.hausberger.hiltsample.retrofit

import com.google.gson.annotations.SerializedName

data class BlogNetworkEntity(

    @SerializedName("pk")
    var id: Int,

    var title: String,

    var body: String,

    var category: String,

    var image: String
)