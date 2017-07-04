package com.app.sample.social.activity_articles.activity_noti;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.app.sample.social.R;
import com.app.sample.social.adapter.ArticlesListAdapter;
import com.app.sample.social.articles_presenter.ArticlesPresenter;
import com.app.sample.social.articles_presenter.ListArticlesContract;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model_articles.ArticlesList;
import com.app.sample.social.presenter.GetFeedNotiPostIdContract;
import com.app.sample.social.presenter.GetFeedNotiPostIdPresenter;

import java.util.List;

public class ActivityNoti extends AppCompatActivity implements GetFeedNotiPostIdContract.HomeViewPostNotiId {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    GetFeedNotiPostIdContract.HomePostNotiIdPresenter presenter;

    public static ArticlesListAdapter adapter;


    private RecyclerView recyclerViewDetails;

    private ActionBar actionBar;
    private View parent_view;

    String userIdPreferences;
    String timeStamp;
    String postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        parent_view = findViewById(android.R.id.content);

        postId = getIntent().getStringExtra("post_id");

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");

        recyclerViewDetails = (RecyclerView) findViewById(R.id.recyclerViewDetails);
        recyclerViewDetails.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewDetails.setHasFixedSize(true);


        initToolbar();


        presenter = new GetFeedNotiPostIdPresenter(this);
        presenter.getAllPostIdFeedNoti(userIdPreferences, postId, timeStamp, "1");


        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle(friend.getHtml().get(0).getName());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_sample:
                Snackbar.make(parent_view, item.getTitle() + " Clicked ", Snackbar.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void showAllFeedNotiPostId(List<GetPostId> feed) {

    }
}
