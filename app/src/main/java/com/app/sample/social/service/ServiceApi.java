package com.app.sample.social.service;

import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.model.Login;
import com.app.sample.social.model.Logout;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.model.PostLike;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    @GET("api.php?type=posts_data&user_id=164")
    Call<Feed2> getAllFilms();

    @GET("api.php?type=posts_data")
    Call<FeedUser> getFeedUser(@Query("user_id") String id,@Query("s") String s);

    @GET("app_api.php?application=phone&type=get_users_friends&user_id=1")
    Call<Friend2> getFriendListUser(@Query("user_id") String id);

    @GET("films/{id}/")
    Call<Feed> getFilm(@Path("id") long id);


    @GET("app_api.php?application=phone&type=user_login&&&")
    Call<Login> getLoginUser(@Query("username") String username, @Query("password") String password, @Query("s") String s);

    @GET("app_api.php?application=phone&type=logout")
    Call<Logout> getLogoutUser(@Query("user_id") String userId, @Query("s") String s);

    @GET("app_api.php?application=phone&type=get_notifications")
    Call<Notifications> getNotiUser(@Query("user_id") String userId, @Query("s") String s);


    @GET("requests_api.php?s=register_like")
    Call<PostLike> postLiked(@Query("post_id") String post_id, @Query("user_id") String user_id);

    @GET("app_api.php?application=phone&type=get_albums")
    Call<PostLike> getAlbums(@Query("user_id") String user_id, @Query("user_profile_id") String user_profile_id, @Query("s") String s);


}
