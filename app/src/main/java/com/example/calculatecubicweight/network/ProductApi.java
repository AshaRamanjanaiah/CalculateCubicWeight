package com.example.calculatecubicweight.network;

import com.example.calculatecubicweight.data.ProductInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("/api/products/1")
    Call<ProductInfo> getProducts();
}
