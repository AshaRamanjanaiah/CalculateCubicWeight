package com.example.calculatecubicweight;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculatecubicweight.data.Objects;
import com.example.calculatecubicweight.data.ProductInfo;
import com.example.calculatecubicweight.network.APIClient;
import com.example.calculatecubicweight.network.ProductApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Objects>> products;
    public LiveData<List<Objects>> getProducts() {
        if (products == null) {
            products = new MutableLiveData<List<Objects>>();
            loadUsers();
        }
        return products;
    }

    private void loadUsers() {
        ProductApi client = APIClient.createService(ProductApi.class);
        Call<ProductInfo> call = client.getProducts();

        call.enqueue(new Callback<ProductInfo>() {
            @Override
            public void onResponse(Call<ProductInfo> call, Response<ProductInfo> response) {
                ProductInfo productInfo = response.body();
                products.setValue(productInfo.getObjects());
            }

            @Override
            public void onFailure(Call<ProductInfo> call, Throwable t) {

            }
        });
    }
}
