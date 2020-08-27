package com.example.kotlin_countries.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_countries.model.Country
import java.util.zip.CheckedOutputStream

@Dao
interface CountryDAO {


    //data access object

    @Insert
    suspend fun insertAll(vararg countries : Country):List<Long>

    @Query ("SELECT * FROM country")
    suspend fun  getAllCountries ():List<Country>

    @Query ("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    @Query("DELETE FROM country")
    suspend fun  deleteAllCountries()

}