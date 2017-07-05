package com.app.sample.social.presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFeedNotiPostIdPresenter implements GetFeedNotiPostIdContract.HomePostNotiIdPresenter {
    private GetFeedNotiPostIdContract.HomeViewPostNotiId view;
    private ServiceApi starWarsApi;
    ArrayList<GetPostId> list = new ArrayList<>();
    ArrayList<String> lusStr = new ArrayList<>();


    public GetFeedNotiPostIdPresenter(GetFeedNotiPostIdContract.HomeViewPostNotiId view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }



    @Override
    public void getAllPostIdFeedNoti(String userId, String post_id, String s, String limit) {


        Log.e("userId", userId);
        Log.e("post_id", post_id);
        Log.e("2", s);
        Log.e("limit", limit);
        starWarsApi.getFeedNoti(userId, post_id, s, limit).enqueue(new Callback<GetPostId>() {
            @Override
            public void onResponse(Call<GetPostId> call, Response<GetPostId> response) {

//                for (int i = 0; i < response.body().getPost_data().si; i++) {
//
//
//                    lusStr.add(response.body().getPost_data().getPhoto_multi().get(i).getImage());
//                    list.clear();
//
//
//
//                }

                list.add(response.body());

                view.showAllFeedNotiPostId(list);

            }

            @Override
            public void onFailure(Call<GetPostId> call, Throwable t) {
                Log.e("getMessage", t.getMessage());
                Log.e("getLocalizedMessage", t.getLocalizedMessage());
            }
        });

    }
}
