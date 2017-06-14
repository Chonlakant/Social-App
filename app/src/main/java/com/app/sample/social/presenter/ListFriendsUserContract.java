package com.app.sample.social.presenter;

import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;

import java.util.List;

public interface ListFriendsUserContract {
    interface HomeViewFriendsUser {
        void showLoading();

        void hideLoading();

        void showAllFriendsUser(List<Friend2> feed);


    }

    interface HomePresenterFriendsUser {
        void getAllFriendsUser(String id);
    }
}
