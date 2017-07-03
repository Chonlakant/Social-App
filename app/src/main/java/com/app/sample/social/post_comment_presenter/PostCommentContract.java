package com.app.sample.social.post_comment_presenter;

import com.app.sample.social.model.PostComment;
import com.app.sample.social.model.PostText;

import java.util.List;

public interface PostCommentContract {
    interface HomeViewPostComment {


        void postComment(List<PostComment> postText);


    }

    interface HomePresenterPostComment {
        void postText(String userId,String timeStamp ,String postText,String post_id );

    }
}
