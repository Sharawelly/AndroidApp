package com.example.myapplication13.network

import com.example.myapplication13.dto.ProductsResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun  getAllProductsFromRemoteDataSource() : Response<ProductsResponse>
}