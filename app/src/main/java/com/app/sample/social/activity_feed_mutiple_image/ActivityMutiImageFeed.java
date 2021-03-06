package com.app.sample.social.activity_feed_mutiple_image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.sample.social.R;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.GetPostImageId;
import com.app.sample.social.model.ObjectImage;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityMutiImageFeed extends AppCompatActivity implements GetFeedPostIdContract.HomeViewPostId {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    ViewPager viewPager;

    MyMutiImagePagerAdapter myImagePagerAdapter;
    GetFeedPostIdContract.HomePostIdPresenter homePostIdPresenter;

    String userIdPreferences;
    String timeStamp;
    String postId;

    ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        postId = getIntent().getStringExtra("postId");
        Log.e("postId", postId);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");

        homePostIdPresenter = new GetFeedPostIdPresenter(this);
        homePostIdPresenter.getAllPostIdFeed(userIdPreferences, postId, timeStamp, "1");


    }

    @Override
    public void showAllFeedPostId(List<GetPostId> feed) {

        for (int i = 0; i < feed.size(); i++) {
            //Log.e("ddddd",feed.get(i).getPost_data().getPhoto_multi().get(i).getImage());
            list.add(feed.get(i).getPost_data().getPhoto_multi().get(i).getImage());
        }


    }

    @Override
    public void showImageArr(ArrayList<ObjectImage> listStr) {
        myImagePagerAdapter = new MyMutiImagePagerAdapter(getApplicationContext(), listStr);
        viewPager.setAdapter(myImagePagerAdapter);
    }

}
