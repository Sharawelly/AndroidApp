package com.example.myapplication13

import com.example.myapplication13.dto.ProductsResponse
import com.example.myapplication13.network.RemoteDataSource
import retrofit2.Response

class ProductsRepositoryImpi(private val remoteDS : RemoteDataSource ) : ProductsRepository {
  override  suspend fun  getAllProductsFromAPI() :Response<ProductsResponse> {
        return remoteDS.getAllProductsFromRemoteDataSource()
    }
}