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
import com.app.sample.social.model.ObjectImage;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityImageFeed extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    ViewPager viewPager;

    MyImagePagerAdapter myImagePagerAdapter;
    ArrayList<ObjectImage> arr = new ArrayList<>();

    GetFeedPostIdContract.HomePostIdPresenter homePostIdPresenter;

    String userIdPreferences;
    String timeStamp;
    String postId;
    String image;
    String avatar;
    String username;
    String time;
    String countLike;
    int countComment;
    boolean isLike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        postId = getIntent().getStringExtra("postId");
        image = getIntent().getStringExtra("array_list");
        avatar = getIntent().getStringExtra("avatar");
        username = getIntent().getStringExtra("username");
        time = getIntent().getStringExtra("time");
        countLike = getIntent().getStringExtra("countLike");
        countComment = getIntent().getIntExtra("countComment",0);
        isLike = getIntent().getBooleanExtra("isLike", false);

        Log.e("postId",postId);
        Log.e("isLike",isLike+"");

        ObjectImage item = new ObjectImage();
        item.setAvatar(avatar);
        item.setImage(image);
        item.setUsername(username);
        item.setLike(isLike);
        item.setPostId(postId);
        item.setTimeStamp(time);
        item.setCountLike(countLike);
        item.setCountComment(countComment);

        arr.add(item);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");


        myImagePagerAdapter = new MyImagePagerAdapter(ActivityImageFeed.this, arr);
        viewPager.setAdapter(myImagePagerAdapter);


    }

}
