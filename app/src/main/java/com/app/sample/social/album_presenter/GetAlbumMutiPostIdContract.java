package com.app.sample.social.album_presenter;

import com.app.sample.social.model.Album;
import com.app.sample.social.model.Album2;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectMutiImageAlbum;

import java.util.ArrayList;
import java.util.List;

public interface GetAlbumMutiPostIdContract {
    interface HomeViewPostId {

        void showAllAlbumMutiPostId(List<Album2> feed);
        void showAllAlbumMutiPostIdArr(List<ObjectMutiImageAlbum> listO);


    }

    interface HomePostIdPresenter {
        void getAllAlbumMutiFeed(String userId, String post_id, String s, String limit);

    }
}
