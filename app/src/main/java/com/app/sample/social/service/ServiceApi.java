package com.app.sample.social.service;

import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    @GET("api.php?type=posts_data&user_id=164")
    Call<Feed2> getAllFilms();

    @GET("api.php?type=posts_data")
    Call<FeedUser> getFeedUser(@Query("user_id") String id);

    @GET("app_api.php?application=phone&type=get_users_friends&user_id=1")
    Call<Friend2> getFriendListUser(@Query("user_id") String id);

    @GET("films/{id}/")
    Call<Feed> getFilm(@Path("id") long id);
}
