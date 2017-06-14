package com.app.sample.social.presenter;


import android.content.Context;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedUserPresenter implements FeedUserContract.HomePresenterUser {
    private FeedUserContract.HomeViewUser viewUser;
    private ServiceApi starWarsApi;
    Context context;
    ArrayList<FeedUser> list = new ArrayList<>();

    public FeedUserPresenter(FeedUserContract.HomeViewUser viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }


    @Override
    public void getAllFeedUser() {
        viewUser.showLoading();


        starWarsApi.getFeedUser("2").enqueue(new Callback<FeedUser>() {
            @Override
            public void onResponse(Call<FeedUser> call, Response<FeedUser> response) {
                for(int i =0;i<response.body().getPosts().size();i++){
                    list.add(response.body());
                }

                viewUser.showAllFeedUser(list);
                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<FeedUser> call, Throwable t) {

            }
        });
    }

    @Override
    public void onFeedItemClicked(FeedUser film) {

    }
}
