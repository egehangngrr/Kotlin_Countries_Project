package com.example.kotlin_countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_countries.R
import com.example.kotlin_countries.databinding.ItemCountryBinding
import com.example.kotlin_countries.model.Country
import com.example.kotlin_countries.util.downloadFromUrl
import com.example.kotlin_countries.util.placeholderProgressBar
import com.example.kotlin_countries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter (val countryList : ArrayList<Country>, private val onClick : (Int)->Unit):
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: ItemCountryBinding): RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return  CountryViewHolder(view)

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.root.setOnClickListener{
            onClick.invoke(holder.view.countryUuidText.text.toString().toInt())
        }


    }

    fun updateCountryList (newCountryList : List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}