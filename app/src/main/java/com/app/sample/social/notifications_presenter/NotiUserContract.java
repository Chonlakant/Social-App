package com.app.sample.social.notifications_presenter;

import com.app.sample.social.model.Login;
import com.app.sample.social.model.Notifications;

import java.util.List;

public interface NotiUserContract {
    interface HomeViewNotoUsers {


        void notiUser(List<Notifications> notificationsList);


    }

    interface HomePresenterNotiUser {
        void notiUser(String userId, String timeStamp);

    }
}
