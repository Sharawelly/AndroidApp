package com.example.myapplication13

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductsViewModelFactory (private  val repo : ProductsRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
     return  if(modelClass.isAssignableFrom(RetrofitViewModel::class.java))
       { RetrofitViewModel(repo) as T
       }
        else {
            throw IllegalArgumentException(" RetrofitViewModel Class not found ")
       }

    }
}