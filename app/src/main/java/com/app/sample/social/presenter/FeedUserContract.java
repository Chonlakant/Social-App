package com.app.sample.social.presenter;

import com.app.sample.social.model.FeedUser;

import java.util.List;

public interface FeedUserContract {
    interface HomeViewUser {
        void showLoading();

        void hideLoading();

        void showTitle(String title);


        void showAllFeedUser(List<FeedUser> feed);


    }

    interface HomePresenterUser {
        void getAllFeedUser(String userid,String user_profile_id,String timeStamp,String limit);

        void onFeedItemClicked(FeedUser film);
    }
}
