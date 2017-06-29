package com.app.sample.social.presenter;


import android.content.Context;
import android.util.Log;

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
    public void getAllFeedUser(String userid, String user_profile_id, String timeStamp, String limit) {
        viewUser.showLoading();


        starWarsApi.getFeedUser(userid, user_profile_id, timeStamp, limit).enqueue(new Callback<FeedUser>() {
            @Override
            public void onResponse(Call<FeedUser> call, Response<FeedUser> response) {
                if (response.body() != null) {
                    for (int i = 0; i < response.body().getPosts().size(); i++) {
                        list.add(response.body());

                    }
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
