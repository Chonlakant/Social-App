package com.app.sample.social.product_presenter;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.app.sample.social.MyApplication;
import com.app.sample.social.api.ApisZaab;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.service.ServiceApiZaab;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter implements ListProductContract.HomePresenterProduct {
    private ListProductContract.HomeViewProduct viewUser;
    private ServiceApiZaab serviceApiZaab;
    ArrayList<product> list = new ArrayList<>();



    public ProductPresenter(ListProductContract.HomeViewProduct viewUser) {
        this.viewUser = viewUser;
        serviceApiZaab = ApisZaab.getApis();
    }

    @Override
    public void getAllProduct(String id) {
        viewUser.showLoading();


        serviceApiZaab.getProduct().enqueue(new Callback<product>() {
            @Override
            public void onResponse(Call<product> call, Response<product> response) {
                for (int i = 0; i < response.body().getHtml().size(); i++) {
                    list.add(response.body());
                }

                viewUser.showAllProduct(list);

                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<product> call, Throwable t) {

            }
        });
    }
}
