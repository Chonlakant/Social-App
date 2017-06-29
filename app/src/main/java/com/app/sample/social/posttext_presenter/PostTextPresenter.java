package com.app.sample.social.posttext_presenter;


import android.widget.Toast;

import com.app.sample.social.MyApplication;
import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.model.PostText;
import com.app.sample.social.notifications_presenter.NotiUserContract;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostTextPresenter implements PostTextContract.HomePresenterPostText {
    private PostTextContract.HomeViewPostText viewUser;
    private ServiceApi starWarsApi;
    ArrayList<PostText> list = new ArrayList<>();


    public PostTextPresenter(PostTextContract.HomeViewPostText viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void postText(String userId, String timeStamp, final String postText) {

        starWarsApi.postText(userId, timeStamp, postText).enqueue(new Callback<PostText>() {
            @Override
            public void onResponse(Call<PostText> call, Response<PostText> response) {

                list.add(response.body());
                viewUser.postText(list);


            }

            @Override
            public void onFailure(Call<PostText> call, Throwable t) {

            }
        });
    }
}
