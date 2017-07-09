package com.app.sample.social.album_presenter_id;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectImage;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAlbumPostIdPresenter implements GetAlbumPostIdContract.HomePostIdPresenter {
    private GetAlbumPostIdContract.HomeViewPostId view;
    private ServiceApi starWarsApi;
    ArrayList<GetPostId> list = new ArrayList<>();
    ArrayList<ObjectImage> lusStr = new ArrayList<>();


    public GetAlbumPostIdPresenter(GetAlbumPostIdContract.HomeViewPostId view) {
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

                for (int i = 0; i < response.body().getPost_data().getPhoto_album().size(); i++) {

                    String postId = response.body().getPost_data().getPost_id();
                    String image = response.body().getPost_data().getPhoto_album().get(i).getImage();
                    String avatar = response.body().getPost_data().getPublisher().getAvatar();
                    String username = response.body().getPost_data().getPublisher().getUsername();
                    String time = response.body().getPost_data().getPost_time();
                    String countLike = response.body().getPost_data().getPost_likes();
                    int countComment = response.body().getPost_data().getGet_post_comments().size();
                    boolean isLike = response.body().getPost_data().isIs_liked();

                    ObjectImage item = new ObjectImage();
                    item.setCountComment(countComment);
                    item.setAvatar(avatar);
                    item.setImage(image);
                    item.setPostId(postId);
                    item.setLike(isLike);
                    item.setUsername(username);
                    item.setTimeStamp(time);
                    item.setCountLike(countLike);
                    lusStr.add(item);

                   // lusStr.add(response.body().getPost_data().getPhoto_album().get(i).getImage());
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
