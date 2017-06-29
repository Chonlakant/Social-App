package com.app.sample.social.presenter;

import com.app.sample.social.model.Feed;

import java.util.List;

public interface FeedContract {
    interface HomeView {
        void showLoading();

        void hideLoading();


        void showAllFeed(List<Feed> feed);


    }

    interface HomePresenter {
        void getAllFeed(String userId,String user_profile_id,String s,String limit);

    }
}
