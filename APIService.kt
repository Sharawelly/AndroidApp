package com.example.myapplication13.network

import retrofit2.http.GET
import com.example.myapplication13.dto.ProductsResponse
import retrofit2.Response


/*
* https://dummyjson.com/products
* https://dummyjson.com/products/id
* https://dummyjson.com/products/search?q=query
* https://dummyjson.com/products/search?limit=3
* https://dummyjson.com/products/search?q=Essence%20Mascara%20Lash%20Princess
* https://dummyjson.com/products/add
* */
interface APIService {
@GET("products")
suspend fun  getAllProducts() :Response<ProductsResponse>
}