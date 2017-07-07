package com.app.sample.social.album_presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Album;
import com.app.sample.social.model.Album2;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectImage;
import com.app.sample.social.model.ObjectMutiImageAlbum;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAlbumMutiPostIdPresenter implements GetAlbumMutiPostIdContract.HomePostIdPresenter {
    private GetAlbumMutiPostIdContract.HomeViewPostId view;
    private ServiceApi starWarsApi;
    ArrayList<Album2> list = new ArrayList<>();
    List<ObjectMutiImageAlbum> listO = new ArrayList<>();

    public GetAlbumMutiPostIdPresenter(GetAlbumMutiPostIdContract.HomeViewPostId view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }


    @Override
    public void getAllAlbumMutiFeed(String userId, String post_id, String s, String limit) {

        starWarsApi.getAlbumMutiId(userId, post_id, s, limit).enqueue(new Callback<Album2>() {
            @Override
            public void onResponse(Call<Album2> call, Response<Album2> response) {
                Log.e("hhhh", response.body().getPost_data().getPhoto_album().size() + "");
                for (int i = 0; i < response.body().getPost_data().getPhoto_album().size(); i++) {

                    Log.e("hhhh", response.body().getPost_data().getPhoto_album().get(i).getImage() + "");

                    String postId = response.body().getPost_data().getPost_id();
                    String image =  response.body().getPost_data().getPhoto_album().get(i).getImage();
                    String avatar = response.body().getPost_data().getPublisher().getAvatar();
                    String username = response.body().getPost_data().getPublisher().getUsername();
                    String time = response.body().getPost_data().getPost_time();
                    String countLike = response.body().getPost_data().getPost_likes();
                    int countComment = response.body().getPost_data().getGet_post_comments().size();
                    boolean isLike = response.body().getPost_data().isIs_liked();

                    ObjectMutiImageAlbum item = new ObjectMutiImageAlbum();
                    item.setCountComment(countComment);
                    item.setAvatar(avatar);
                    item.setImage(image);
                    item.setPostId(postId);
                    item.setLike(isLike);
                    item.setUsername(username);
                    item.setTimeStamp(time);
                    item.setCountLike(countLike);
                    listO.add(item);

                    list.clear();
                    list.add(response.body());


                }

                view.showAllAlbumMutiPostId(list);
                view.showAllAlbumMutiPostIdArr(listO);
            }

            @Override
            public void onFailure(Call<Album2> call, Throwable t) {

            }
        });
    }
}
