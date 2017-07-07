package com.app.sample.social.presenter;

import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectImage;

import java.util.ArrayList;
import java.util.List;

public interface GetFeedPostIdContract {
    interface HomeViewPostId {

        void showAllFeedPostId(List<GetPostId> feed);
        void showImageArr(ArrayList<ObjectImage> listStr);


    }

    interface HomePostIdPresenter {
        void getAllPostIdFeed(String userId, String post_id, String s, String limit);

    }
}
