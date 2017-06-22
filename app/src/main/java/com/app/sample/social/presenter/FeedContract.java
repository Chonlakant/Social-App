package com.app.sample.social.presenter;

import com.app.sample.social.adapter.FeedListAdapter2;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;

import java.util.List;

public interface FeedContract {
    interface HomeView {
        void showLoading();

        void hideLoading();


        void showAllFeed(List<Feed2> feed);


    }

    interface HomePresenter {
        void getAllFeed();

    }
}
