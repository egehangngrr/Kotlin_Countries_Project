package com.example.kotlin_countries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_countries.model.Country
import com.example.kotlin_countries.db.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun  getDataFromRoom (uuid : Int) {

        launch {
            val dao = CountryDatabase(
                getApplication()
            ).countryDao()
            val country =dao.getCountry(uuid)
            countryLiveData.value = country

        }

    }

}