package com.app.sample.social.product_presenter;


import android.content.Context;
import android.util.Log;

import com.app.sample.social.api.ApisZaab;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.service.ServiceApiZaab;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductIdPresenter implements ListProductIdContract.HomePresenterProduct {
    private ListProductIdContract.HomeViewProduct viewUser;
    private ServiceApiZaab serviceApiZaab;
    Context context;
    ArrayList<productDetails> list = new ArrayList<>();
    ArrayList<productDetails> listImage = new ArrayList<>();


    public ProductIdPresenter(ListProductIdContract.HomeViewProduct viewUser) {
        this.viewUser = viewUser;
        serviceApiZaab = ApisZaab.getApis();
    }

    @Override
    public void getAllProduct(String id) {
        viewUser.showLoading();


        serviceApiZaab.getProductId().enqueue(new Callback<productDetails>() {
            @Override
            public void onResponse(Call<productDetails> call, Response<productDetails> response) {


                for (int i = 0; i < response.body().getHtml().size(); i++) {
                    list.add(response.body());
                }


                viewUser.showAllProduct(list);
                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<productDetails> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAllImageProduct(String id) {

        serviceApiZaab.getProductImageId().enqueue(new Callback<productDetails>() {
            @Override
            public void onResponse(Call<productDetails> call, Response<productDetails> response) {


                for (int i = 0; i < response.body().getHtml().size(); i++) {
                    listImage.add(response.body());
                    Log.e("bbbb",response.body().getHtml().get(i).getImages().size()+"");
                    Log.e("bbbb",response.body().getHtml().get(i).getImages().get(i).getImage()+"");
                }

                viewUser.showAllImageProduct(listImage);
                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<productDetails> call, Throwable t) {

            }
        });
    }

}
