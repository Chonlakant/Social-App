package com.app.sample.social.service;

import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceApi {
    @GET("posts/user_timeline/2?page=1&type=&per_page=20")
    Call<Feed2> getAllFilms();

    @GET("posts/user_timeline/{id}?page=1&type=&per_page=20")
    Call<FeedUser> getFeedUser(@Path("id") String id);

    @GET("/friends/{id}")
    Call<Friend2> getFriendListUser(@Path("id") String id);

    @GET("films/{id}/")
    Call<Feed> getFilm(@Path("id") long id);
}
