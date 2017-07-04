package com.app.sample.social.post_comment_presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.PostComment;
import com.app.sample.social.model.PostText;
import com.app.sample.social.posttext_presenter.PostTextContract;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostCommentPresenter implements PostCommentContract.HomePresenterPostComment {
    private PostCommentContract.HomeViewPostComment viewUser;
    private ServiceApi starWarsApi;
    ArrayList<PostComment> list = new ArrayList<>();


    public PostCommentPresenter(PostCommentContract.HomeViewPostComment viewUser) {
        this.viewUser = viewUser;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void postText(String userId,  String timeStamp , String postText, String post_id) {


        starWarsApi.postCommentId(userId, timeStamp , postText, post_id).enqueue(new Callback<PostComment>() {
            @Override
            public void onResponse(Call<PostComment> call, Response<PostComment> response) {

                list.add(response.body());
                viewUser.postComment(list);
            }

            @Override
            public void onFailure(Call<PostComment> call, Throwable t) {

            }
        });
    }
}
