package com.app.sample.social.presenter;

import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public interface GetFeedPostIdContract {
    interface HomeViewPostId {

        void showAllFeedPostId(List<GetPostId> feed);
        void showImageArr(ArrayList<String> listStr);


    }

    interface HomePostIdPresenter {
        void getAllPostIdFeed(String userId, String user_profile_id, String s, String limit);

    }
}
