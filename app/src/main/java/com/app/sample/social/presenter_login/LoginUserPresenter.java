package com.app.sample.social.presenter_login;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Login;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserPresenter implements LoginUserContract.HomePresenterLogoinUser {
    private LoginUserContract.HomeViewLoginUsers viewUser;
    private ServiceApi starWarsApi;
    ArrayList<Login> list = new ArrayList<>();

    public LoginUserPresenter(LoginUserContract.HomeViewLoginUsers viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void loginUser(String email, String pass, String time) {
        starWarsApi.getLoginUser(email, pass, time).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                list.add(response.body());
                viewUser.loginUser(list);

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });

    }
}
