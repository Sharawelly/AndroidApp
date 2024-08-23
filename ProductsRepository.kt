package com.example.myapplication13

import com.example.myapplication13.dto.ProductsResponse
import retrofit2.Response

interface ProductsRepository {
    suspend fun  getAllProductsFromAPI() : Response<ProductsResponse>
}