package com.example.hitldaggernavigationcomponent.di

import com.example.hitldaggernavigationcomponent.ApiInterface.ApiResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    private fun getApiInterface(retrofit: Retrofit) : ApiResponse{
       return retrofit.create(ApiResponse::class.java)
    }

    @Provides
    @Singleton
    private fun getRetrofitInstance(){
       Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}