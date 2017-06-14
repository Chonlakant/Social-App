package com.app.sample.social.service;

import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Friend2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceApiZaab {

    @GET("requests_api.php?f=search_products")
    Call<product> getProduct();

    @GET("requests_api.php?f=search_products&id=54")
    Call<productDetails> getProductId();

    @GET("requests_api.php?f=search_products&id=57")
    Call<productDetails> getProductImageId();

}
