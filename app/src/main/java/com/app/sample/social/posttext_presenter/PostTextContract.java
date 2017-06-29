package com.app.sample.social.posttext_presenter;

import com.app.sample.social.model.Notifications;
import com.app.sample.social.model.PostText;

import java.util.List;

public interface PostTextContract {
    interface HomeViewPostText {


        void postText(List<PostText> postText);


    }

    interface HomePresenterPostText {
        void postText(String userId, String timeStamp,String postText);

    }
}
