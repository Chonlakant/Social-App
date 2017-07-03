package com.app.sample.social.presenter;


import android.util.Log;

import com.app.sample.social.api.Apis;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectComment;
import com.app.sample.social.service.ServiceApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFeedPostCommentIdPresenter implements GetFeedPostCommentIdContract.HomePostIdPresenter {
    private GetFeedPostCommentIdContract.HomeViewPostId view;
    private ServiceApi starWarsApi;
    ArrayList<GetPostId> list = new ArrayList<>();
    ArrayList<ObjectComment> lusStr = new ArrayList<>();


    public GetFeedPostCommentIdPresenter(GetFeedPostCommentIdContract.HomeViewPostId view) {
        this.view = view;
        starWarsApi = Apis.getApis();
    }

    @Override
    public void getAllPostCommentIdFeed(String userId, String user_profile_id, String s, String limit) {
        starWarsApi.getCommentId(userId, user_profile_id, s, limit).enqueue(new Callback<GetPostId>() {
            @Override
            public void onResponse(Call<GetPostId> call, Response<GetPostId> response) {

                for (int i = 0; i < response.body().getPost_data().getGet_post_comments().size(); i++) {

                Log.e("hhhh",response.body().getPost_data().getGet_post_comments().get(i).getText());
//                    lusStr.add(response.body().getPost_data().getPhoto_multi().get(i).getImage());
                    list.clear();
                    list.add(response.body());


                    ObjectComment l = new ObjectComment();
                    l.setName(response.body().getPost_data().getGet_post_comments().get(i).getPublisher().getUsername());
                    l.setAvatar(response.body().getPost_data().getGet_post_comments().get(i).getPublisher().getAvatar());
                    l.setTextComment(response.body().getPost_data().getGet_post_comments().get(i).getText());
                    view.showAllCommentPostId(list);
                    lusStr.add(l);

                }


                view.showCommentArr(lusStr);
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
