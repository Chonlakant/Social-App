package com.app.sample.social.presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Feed;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedPresenter implements FeedContract.HomePresenter {
    private FeedContract.HomeView view;
    private ServiceApi starWarsApi;
    ArrayList<Feed> list = new ArrayList<>();

    public FeedPresenter(FeedContract.HomeView view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllFeed(String userId,String user_profile_id,String s,String limit) {
        view.showLoading();

        starWarsApi.getAllFilms(userId,user_profile_id,s,limit).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                list.clear();
                for(int i =0;i<response.body().getPosts().size();i++){

                    list.add(response.body());
                    Log.e("dddd",response.body().getPosts().get(i).getGet_post_comments()+"");

                }
                view.showAllFeed(list);

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {

                view.hideLoading();
            }
        });

    }


}
