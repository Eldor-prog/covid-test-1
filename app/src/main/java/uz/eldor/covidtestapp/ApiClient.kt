package uz.eldor.covidtestapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://corona.lmao.ninja/v3/covid-19/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}