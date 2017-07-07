package com.app.sample.social.activity_feed_mutiple_image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityImageFeed extends AppCompatActivity   {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    ViewPager viewPager;

    MyImagePagerAdapter myImagePagerAdapter;
    ArrayList<String> arr = new ArrayList<>();

    GetFeedPostIdContract.HomePostIdPresenter homePostIdPresenter;

    String userIdPreferences;
    String timeStamp;
    String postId;
    String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        postId = getIntent().getStringExtra("postId");
        image = getIntent().getStringExtra("array_list");
        arr.add(image);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");



        myImagePagerAdapter = new MyImagePagerAdapter(ActivityImageFeed.this, arr);
        viewPager.setAdapter(myImagePagerAdapter);


    }

}
