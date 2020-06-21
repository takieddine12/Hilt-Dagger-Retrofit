package com.example.hitldaggernavigationcomponent.models

import retrofit2.http.Body

data class JsonHodlerApiModel(
    var id : String? = null,
    var title : String? = null,
    var body: String? = null
)