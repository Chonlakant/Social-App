package com.app.sample.social.product_presenter;


import android.content.Context;
import android.util.Log;

import com.app.sample.social.api.ApisZaab;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.mode_product.productImage;
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
    ArrayList<productImage> listStrImage = new ArrayList<>();


    public ProductIdPresenter(ListProductIdContract.HomeViewProduct viewUser) {
        this.viewUser = viewUser;
        serviceApiZaab = ApisZaab.getApis();
    }

    @Override
    public void getAllProduct(String id) {
        viewUser.showLoading();


        serviceApiZaab.getProductId(id).enqueue(new Callback<productDetails>() {
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

        serviceApiZaab.getProductImageId(id).enqueue(new Callback<productDetails>() {
            @Override
            public void onResponse(Call<productDetails> call, Response<productDetails> response) {


                for (int i = 0; i < response.body().getHtml().size(); i++) {
                    listImage.add(response.body());
                    for (int j = 0; j < response.body().getHtml().get(i).getImages().size(); j++) {
                        String url = response.body().getHtml().get(i).getImages().get(j).getImage();
                        productImage urlImage = new productImage();
                        urlImage.setImageUrl(url);
                        listStrImage.add(urlImage);

                    }

                }

                viewUser.showAllImageProduct(listStrImage);
                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<productDetails> call, Throwable t) {

            }
        });
    }

}
