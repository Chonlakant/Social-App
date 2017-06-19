package com.app.sample.social.activity_viedo_full;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.app.sample.social.R;
import com.app.sample.social.adapter.ArticlesListAdapter;
import com.app.sample.social.articles_presenter.ArticlesPresenter;
import com.app.sample.social.articles_presenter.ListArticlesContract;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model_articles.ArticlesList;

import java.util.List;

public class ActivityFullVideo extends AppCompatActivity {

    VideoView myvideoView;
    String urlvdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_full);
        urlvdo = getIntent().getStringExtra("urlvdo");
        myvideoView = (VideoView) findViewById(R.id.myvideoView);

        myvideoView.setVideoPath(urlvdo);

        //play pause stop

        MediaController mediaController = new MediaController(ActivityFullVideo.this);
        mediaController.setAnchorView(myvideoView);
        myvideoView.setMediaController(mediaController);

        myvideoView.start();

    }


}
