package com.app.sample.social.album_presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Album;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.presenter.GetFeedNotiPostIdContract;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAlbumIdPresenter implements GetAlbumIdContract.HomePostAlbumIdPresenter {
    private GetAlbumIdContract.HomeViewAlbumId view;
    private ServiceApi starWarsApi;
    ArrayList<Album> list = new ArrayList<>();


    public GetAlbumIdPresenter(GetAlbumIdContract.HomeViewAlbumId view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllPostIdAlbum(String userId, String user_profile_id, String s, String limit, String album) {

        Log.e("userId", userId);
        Log.e("post_id", user_profile_id);
        Log.e("s", s);
        Log.e("limit", limit);
        Log.e("album", album);
        starWarsApi.getAlbum(userId, user_profile_id, s, limit, album).enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                for (int i = 0; i < response.body().getPosts().size(); i++) {

                    list.add(response.body());

                }
                view.showAllAlbumId(list);

            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

            }
        });

    }
}
