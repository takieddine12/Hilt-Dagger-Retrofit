package com.example.hitldaggernavigationcomponent

import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MultiTapKeyListener
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.hitldaggernavigationcomponent.ApiInterface.ApiResponse
import com.example.hitldaggernavigationcomponent.models.JsonHodlerApiModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    private lateinit var apiResponse : ApiResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiResponse.getPosts().enqueue(object : retrofit2.Callback<MutableList<JsonHodlerApiModel>>{
            override fun onFailure(call: Call<MutableList<JsonHodlerApiModel>>, t: Throwable) {
                Log.d("TAG","Error ${t.message}")
            }

            override fun onResponse(call: Call<MutableList<JsonHodlerApiModel>>, response: Response<MutableList<JsonHodlerApiModel>>) {
                if(response.body() != null && response.isSuccessful) {
                    var itemsList = response.body()
                    PopulateList(itemsList!!)
                }
            }
        })
    }

    private fun PopulateList(list : MutableList<JsonHodlerApiModel>){
        for(i in list.indices){
            var model = JsonHodlerApiModel(list[i].id,list[i].title,list[i].body)
            list.add(model)
            listview.adapter =  ListAdapter(this,list)
        }
    }
}