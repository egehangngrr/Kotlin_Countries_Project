package com.example.kotlin_countries.service

import com.example.kotlin_countries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    // GET POST

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries ():Single<List<Country>>

}