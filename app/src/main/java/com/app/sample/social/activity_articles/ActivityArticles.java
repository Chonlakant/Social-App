package com.app.sample.social.activity_articles;

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
import android.widget.EditText;

import com.app.sample.social.R;
import com.app.sample.social.adapter.ArticlesListAdapter;
import com.app.sample.social.adapter.ProductDetailsListAdapter;
import com.app.sample.social.articles_presenter.ArticlesPresenter;
import com.app.sample.social.articles_presenter.ListArticlesContract;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model_articles.ArticlesList;

import java.util.ArrayList;
import java.util.List;

public class ActivityArticles extends AppCompatActivity implements ListArticlesContract.HomeViewArticles {

    public static String KEY_FRIEND = "com.app.sample.social.FRIEND";
    public static String KEY_SNIPPET = "com.app.sample.social.SNIPPET";

    ListArticlesContract.HomePresenterArticles presenter;

    public static ArticlesListAdapter adapter;


    private RecyclerView recyclerViewDetails;

    private ActionBar actionBar;
    private View parent_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        parent_view = findViewById(android.R.id.content);


        recyclerViewDetails = (RecyclerView) findViewById(R.id.recyclerViewDetails);
        recyclerViewDetails.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewDetails.setHasFixedSize(true);


        // animation transition
        ViewCompat.setTransitionName(parent_view, KEY_FRIEND);

        initToolbar();


        presenter = new ArticlesPresenter(this);
        presenter.getAllArticles("");


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

    /**
     * Handle click on action bar
     **/
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
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showAllArticles(List<ArticlesList> articlesLists) {
        adapter = new ArticlesListAdapter(getApplicationContext(), articlesLists);
        recyclerViewDetails.setAdapter(adapter);
    }


}
