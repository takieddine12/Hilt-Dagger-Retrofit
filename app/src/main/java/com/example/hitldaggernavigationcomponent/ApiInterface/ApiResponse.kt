package com.example.hitldaggernavigationcomponent.ApiInterface

import android.telecom.Call
import com.example.hitldaggernavigationcomponent.models.JsonHodlerApiModel
import retrofit2.http.GET

interface ApiResponse {

    @GET("posts")
    fun getPosts() : retrofit2.Call<MutableList<JsonHodlerApiModel>>
}