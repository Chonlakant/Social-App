package com.app.sample.social.presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFeedPostIdPresenter implements GetFeedPostIdContract.HomePostIdPresenter {
    private GetFeedPostIdContract.HomeViewPostId view;
    private ServiceApi starWarsApi;
    ArrayList<GetPostId> list = new ArrayList<>();
    ArrayList<String> lusStr = new ArrayList<>();


    public GetFeedPostIdPresenter(GetFeedPostIdContract.HomeViewPostId view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllPostIdFeed(String userId, String post_id, String s, String limit) {

        Log.e("userId", userId);
        Log.e("post_id", post_id);
        Log.e("2", s);
        Log.e("limit", limit);
        starWarsApi.getFeedId(userId, post_id, s, limit).enqueue(new Callback<GetPostId>() {
            @Override
            public void onResponse(Call<GetPostId> call, Response<GetPostId> response) {

                for (int i = 0; i < response.body().getPost_data().getPhoto_multi().size(); i++) {

                    Log.e("hhhh", response.body().getPost_data().getPhoto_multi().get(i).getImage() + "");
                    lusStr.add(response.body().getPost_data().getPhoto_multi().get(i).getImage());
                    list.clear();
                    list.add(response.body());


                }

                view.showAllFeedPostId(list);
                view.showImageArr(lusStr);
                // Log.e("hhhh", response.body().getPost_data().getPhoto_multi().get(i).getImage()+ "");

            }

            @Override
            public void onFailure(Call<GetPostId> call, Throwable t) {
                Log.e("getMessage", t.getMessage());
                Log.e("getLocalizedMessage", t.getLocalizedMessage());
            }
        });

    }
}
