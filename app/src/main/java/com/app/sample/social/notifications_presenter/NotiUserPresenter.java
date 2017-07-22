package com.app.sample.social.notifications_presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotiUserPresenter implements NotiUserContract.HomePresenterNotiUser {
    private NotiUserContract.HomeViewNotoUsers viewUser;
    private ServiceApi starWarsApi;
    ArrayList<Notifications> list = new ArrayList<>();



    public NotiUserPresenter(NotiUserContract.HomeViewNotoUsers viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void notiUser(String userId, String timeStamp) {
        starWarsApi.getNotiUser(userId, timeStamp).enqueue(new Callback<Notifications>() {
            @Override
            public void onResponse(Call<Notifications> call, Response<Notifications> response) {

                for(int i = 0 ; i < response.body().getNotifications().size();i++){
                    list.add(response.body());
                }

                Log.e("headers",response.headers()+"");


                viewUser.notiUser(list);
            }

            @Override
            public void onFailure(Call<Notifications> call, Throwable t) {


            }
        });
    }
}
