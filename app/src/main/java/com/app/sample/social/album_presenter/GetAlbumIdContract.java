package com.app.sample.social.album_presenter;

import com.app.sample.social.model.Album;
import com.app.sample.social.model.GetPostId;

import java.util.List;

public interface GetAlbumIdContract {
    interface HomeViewAlbumId {

        void showAllAlbumId(List<Album> feed);

    }

    interface HomePostAlbumIdPresenter {
        void getAllPostIdAlbum(String userId, String user_profile_id, String s, String limit,String album);

    }
}
