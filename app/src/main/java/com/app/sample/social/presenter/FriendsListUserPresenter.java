package com.app.sample.social.presenter;


import android.content.Context;
import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsListUserPresenter implements ListFriendsUserContract.HomePresenterFriendsUser {
    private ListFriendsUserContract.HomeViewFriendsUser viewUser;
    private ServiceApi starWarsApi;
    Context context;
    ArrayList<Friend2> list = new ArrayList<>();



    public FriendsListUserPresenter(ListFriendsUserContract.HomeViewFriendsUser viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllFriendsUser(String id) {
        viewUser.showLoading();


        starWarsApi.getFriendListUser(id).enqueue(new Callback<Friend2>() {
            @Override
            public void onResponse(Call<Friend2> call, Response<Friend2> response) {
                for (int i = 0; i < response.body().getFriends().size(); i++) {
                    list.add(response.body());
                }

                viewUser.showAllFriendsUser(list);
                viewUser.hideLoading();
            }

            @Override
            public void onFailure(Call<Friend2> call, Throwable t) {

            }
        });
    }
}
