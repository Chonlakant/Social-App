package com.app.sample.social.service;

import com.app.sample.social.model.Album;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.GetPostImageId;
import com.app.sample.social.model.Login;
import com.app.sample.social.model.Logout;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.model.PostComment;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.model.PostProduct;
import com.app.sample.social.model.PostText;
import com.app.sample.social.model.UserProfile;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ServiceApi {

    @GET("app_api.php?application=phone&type=get_user_posts&")
    Call<Feed> getAllFilms(@Query("user_id") String id,
                           @Query("user_profile_id") String user_profile_id,
                           @Query("s") String s,
                           @Query("limit") String limit);


    @GET("app_api.php?application=phone&type=get_user_data&")
    Call<UserProfile> getUserProfile(@Query("user_id") String id, @Query("user_profile_id") String user_profile_id, @Query("s") String s);


    @GET("app_api.php?application=phone&type=get_post_data&")
    Call<GetPostId> getFeedId(@Query("user_id") String id,
                              @Query("post_id") String post_id,
                              @Query("s") String s,
                              @Query("limit") String limit);


    @GET("app_api.php?application=phone&type=get_post_data&")
    Call<GetPostId> getFeedNoti(@Query("user_id") String id,
                                @Query("post_id") String post_id,
                                @Query("s") String s,
                                @Query("limit") String limit);

    @GET("app_api.php?application=phone&type=get_user_posts&")
    Call<Album> getAlbum(@Query("user_id") String id,
                        @Query("user_profile_id") String user_profile_id,
                        @Query("s") String s,
                        @Query("limit") String limit,
                        @Query("album") String album);


    @GET("app_api.php?application=phone&type=get_post_data&")
    Call<GetPostId> getCommentId(@Query("user_id") String id,
                                 @Query("post_id") String post_id,
                                 @Query("s") String s,
                                 @Query("limit") String limit);


    @FormUrlEncoded
    @POST("app_api.php?application=phone&type=new_comment")
    Call<PostComment> postCommentId(@Field("user_id") String user_id,
                                    @Field("s") String s,
                                    @Field("text") String text,
                                    @Field("post_id") String post_id);


    @GET("app_api.php?application=phone&type=get_user_posts&")
    Call<FeedUser> getFeedUser(@Query("user_id") String id,
                               @Query("user_profile_id") String user_profile_id,
                               @Query("s") String s,
                               @Query("limit") String limit);

    @GET("app_api.php?application=phone&type=get_users_friends&user_id=1")
    Call<Friend2> getFriendListUser(@Query("user_id") String id);

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

    @FormUrlEncoded
    @POST("app_api.php?application=phone&type=new_post")
    Call<PostText> postText(@Field("user_id") String user_id, @Field("s") String s, @Field("postText") String postText);


//    @Multipart
//    @POST("app_api.php?application=phone&type=new_product")
//    Call<PostProduct> postProduct(@Field("user_id") String user_id
//            , @Field("s") String s
//            , @Field("name") String name,
//                                  @Field("description") String description,
//                                  @Part ("postPhotos") MultipartBody.Part file,
//                                  @Field("price") String price,
//                                  @Field("category") String category,
//                                  @Field("type") String type,
//                                  @Field("location") String location);

    @Multipart
    @POST("app_api.php?application=phone&type=new_product")
    Call<PostProduct> postProduct(@Part("user_id") RequestBody user_id
            , @Part("s") RequestBody s
            , @Part("name") RequestBody name,
                                  @Part("description") RequestBody description,
                                  @Part("postPhotos") MultipartBody.Part filename,
                                  @Part("price") RequestBody price,
                                  @Part("category") RequestBody category,
                                  @Part("type") RequestBody type,
                                  @Part("location") RequestBody location);


}
