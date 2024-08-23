package com.example.myapplication13

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.myapplication13.dto.Product


class RetrofitViewModel(private  val repo : ProductsRepository): ViewModel() {
    private val _productsList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productsList

    private val _isRemoteSourseError =MutableLiveData<Boolean>()
    val isRemoteSourseError :LiveData<Boolean> =_isRemoteSourseError



    fun getAllProducts (){
        viewModelScope.launch{
            val response =repo.getAllProductsFromAPI()
            if(response.isSuccessful) {
                _productsList.postValue(response.body()?.productsList)//(body---> Products Response)
            }else{
                //handle Error Response
             _isRemoteSourseError.postValue( true)
            }

        }
    }
}