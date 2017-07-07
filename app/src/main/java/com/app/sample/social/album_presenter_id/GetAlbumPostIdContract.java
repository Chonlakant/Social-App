package com.app.sample.social.album_presenter_id;

import com.app.sample.social.mode_product.productImage;
import com.app.sample.social.model.GetPostId;

import java.util.ArrayList;
import java.util.List;

public interface GetAlbumPostIdContract {
    interface HomeViewPostId {

        void showAllFeedPostId(List<GetPostId> feed);
        void showImageArr(ArrayList<String> listStr);




    }

    interface HomePostIdPresenter {
        void getAllPostIdFeed(String userId, String post_id, String s, String limit);

    }
}
