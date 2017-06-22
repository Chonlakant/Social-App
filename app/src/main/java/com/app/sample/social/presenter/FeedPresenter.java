package com.app.sample.social.presenter;


import android.content.Context;
import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.mode_product.productImage;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedPresenter implements FeedContract.HomePresenter {
    private FeedContract.HomeView view;
    private ServiceApi starWarsApi;
    Context context;
    ArrayList<Feed2> list = new ArrayList<>();

    public FeedPresenter(FeedContract.HomeView view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllFeed() {
        view.showLoading();

        starWarsApi.getAllFilms().enqueue(new Callback<Feed2>() {
            @Override
            public void onResponse(Call<Feed2> call, Response<Feed2> response) {

                for(int i =0;i<response.body().getItems().size();i++){
                    list.add(response.body());
                }
                view.showAllFeed(list);
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Feed2> call, Throwable t) {

                view.hideLoading();
            }
        });

    }


}
