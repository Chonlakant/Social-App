package com.app.sample.social.presenter;

import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public interface GetFeedPostCommentIdContract {
    interface HomeViewPostId {

        void showAllCommentPostId(List<GetPostId> feed);
        void showCommentArr(ArrayList<String> listStr);


    }

    interface HomePostIdPresenter {
        void getAllPostCommentIdFeed(String userId, String user_profile_id, String s, String limit);

    }
}
