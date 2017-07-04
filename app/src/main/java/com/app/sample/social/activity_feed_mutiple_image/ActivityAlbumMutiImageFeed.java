package com.app.sample.social.activity_feed_mutiple_image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.sample.social.R;
import com.app.sample.social.album_presenter.GetAlbumMutiPostIdContract;
import com.app.sample.social.album_presenter.GetAlbumMutiPostIdPresenter;
import com.app.sample.social.model.Album;
import com.app.sample.social.model.Album2;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectMutiImageAlbum;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityAlbumMutiImageFeed extends AppCompatActivity implements GetAlbumMutiPostIdContract.HomeViewPostId {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    ViewPager viewPager;

    MyAlbumMutiImagePagerAdapter myImagePagerAdapter;
    GetAlbumMutiPostIdContract.HomePostIdPresenter homePostIdPresenter;

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

        homePostIdPresenter = new GetAlbumMutiPostIdPresenter(this);
        homePostIdPresenter.getAllAlbumMutiFeed(userIdPreferences, postId, timeStamp, "1");


    }


    @Override
    public void showAllAlbumMutiPostId(List<Album2> feed) {




    }

    @Override
    public void showAllAlbumMutiPostIdArr(List<ObjectMutiImageAlbum> listO) {
        myImagePagerAdapter = new MyAlbumMutiImagePagerAdapter(getApplicationContext(), listO);
        viewPager.setAdapter(myImagePagerAdapter);
    }
}
