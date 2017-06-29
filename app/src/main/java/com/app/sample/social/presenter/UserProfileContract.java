package com.app.sample.social.presenter;

import com.app.sample.social.model.UserProfile;

import java.util.List;

public interface UserProfileContract {
    interface HomeViewUserProfile {



        void showUserProfile(List<UserProfile> feed);


    }

    interface HomePresenteUserProfile {
        void getAllUserProfile(String userId,String user_profile_id,String timeStamp);

    }
}
