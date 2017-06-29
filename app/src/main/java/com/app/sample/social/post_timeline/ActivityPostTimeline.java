package com.app.sample.social.post_timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.sample.social.MyApplication;
import com.app.sample.social.R;
import com.app.sample.social.activity_mutiple_image.ActivityMutipleImage;
import com.app.sample.social.adapter.ProductDetailsImageListAdapter;
import com.app.sample.social.adapter.ProductDetailsListAdapter;
import com.app.sample.social.data.Tools;
import com.app.sample.social.mode_product.product;
import com.app.sample.social.mode_product.productDetails;
import com.app.sample.social.mode_product.productImage;
import com.app.sample.social.model.PostText;
import com.app.sample.social.posttext_presenter.PostTextContract;
import com.app.sample.social.posttext_presenter.PostTextPresenter;
import com.app.sample.social.presenter.FeedPresenter;
import com.app.sample.social.product_presenter.ListProductIdContract;
import com.app.sample.social.product_presenter.ProductIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class ActivityPostTimeline extends AppCompatActivity implements PostTextContract.HomeViewPostText {


    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";
    String userIdPreferences;
    String timeStamp;

    EditText dt_post;
    Button btn_post;

    PostTextContract.HomePresenterPostText presenter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);

        dt_post = (EditText) findViewById(R.id.dt_post);
        btn_post = (Button) findViewById(R.id.btn_post);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");

        presenter = new PostTextPresenter(this);


        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postText(userIdPreferences, timeStamp, dt_post.getText().toString());
            }
        });
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

    public void postText(String userId, String s, String postText) {

        presenter.postText(userId, s, postText);
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

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void postText(List<PostText> postText) {

        Log.e("postText",postText.get(0).getApi_status());
        if (postText.get(0).getApi_status().equals("200")) {
            Toast.makeText(MyApplication.getAppContext(),"สำเร็จ",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MyApplication.getAppContext(),"ไม่สำเร็จ",Toast.LENGTH_SHORT).show();
        }

    }
}
