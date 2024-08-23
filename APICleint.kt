package com.example.myapplication13.network

import com.example.myapplication13.dto.ProductsResponse
import retrofit2.Response

object APICleint : RemoteDataSource{
    override suspend fun getAllProductsFromRemoteDataSource(): Response<ProductsResponse> {
         return API.retrofitService.getAllProducts()
    }
}