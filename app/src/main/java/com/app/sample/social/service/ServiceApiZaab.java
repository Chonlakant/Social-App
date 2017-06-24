package com.app.sample.social.service;

import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.model_articles.ArticlesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApiZaab {

    @GET("requests_api.php?f=search_products")
    Call<product> getProduct();

    @GET("requests_api.php?f=search_products")
    Call<productDetails> getProductId(@Query("id") String id);

    @GET("requests_api.php?f=search_products")
    Call<productDetails> getProductImageId(@Query("id") String id);

    @GET("requests_api.php?f=load-recent-blogs")
    Call<ArticlesList> getArticles();



    @GET("requests_api.php?f=search_products")
    Call<productDetails> getMutipleImageId(@Query("id") String id);

}
