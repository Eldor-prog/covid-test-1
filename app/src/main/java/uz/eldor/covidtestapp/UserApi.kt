package uz.eldor.covidtestapp

import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("all")
    fun getUserData() : Call<UserData>
}