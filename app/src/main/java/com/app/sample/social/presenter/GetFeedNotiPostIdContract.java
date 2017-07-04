package com.app.sample.social.presenter;

import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public interface GetFeedNotiPostIdContract {
    interface HomeViewPostNotiId {

        void showAllFeedNotiPostId(List<GetPostId> feed);

    }

    interface HomePostNotiIdPresenter {
        void getAllPostIdFeedNoti(String userId, String post_id, String s, String limit);

    }
}
