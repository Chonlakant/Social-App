package com.app.sample.social.presenter;


import com.app.sample.social.api.Apis;
import com.app.sample.social.model.UserProfile;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfilePresenter implements UserProfileContract.HomePresenteUserProfile {
    private UserProfileContract.HomeViewUserProfile view;
    private ServiceApi starApi;
    ArrayList<UserProfile> list = new ArrayList<>();

    public UserProfilePresenter(UserProfileContract.HomeViewUserProfile view) {
        this.view = view;
        starApi = Apis.getApis();
    }

    @Override
    public void getAllUserProfile(String userId, String user_profile_id, String timeStamp) {


        starApi.getUserProfile(userId, user_profile_id, timeStamp).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {

                list.add(response.body());
                view.showUserProfile(list);

            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });

    }
}
