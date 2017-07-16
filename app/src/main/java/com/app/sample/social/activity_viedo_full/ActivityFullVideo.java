package com.app.sample.social.activity_viedo_full;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.R;
import com.app.sample.social.activity_comment.CommentsActivity;
import com.app.sample.social.adapter.ArticlesListAdapter;
import com.app.sample.social.api.Apis;
import com.app.sample.social.articles_presenter.ArticlesPresenter;
import com.app.sample.social.articles_presenter.ListArticlesContract;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.model_articles.ArticlesList;
import com.app.sample.social.service.ServiceApi;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityFullVideo extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    VideoView myvideoView;
    String urlvdo;

    ImageView photo_profile;
    TextView text_name;
    TextView text_date;
    ImageButton bt_like;
    ImageButton bt_comment;
    ImageButton btnMore;
    TextSwitcher txt_like;
    TextView txt_count_comments;

    String username;
    String cover;
    String postId;
    String avatar;
    String countLike;
    int countComment;
    String userId;
    String time;
    boolean isLike;


    String userIdPreferences;
    String timeStamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_full);


        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");
        Log.e("userIdPreferences", userIdPreferences);

        username = getIntent().getStringExtra("username");
        cover = getIntent().getStringExtra("cover");
        postId = getIntent().getStringExtra("postId");
        avatar = getIntent().getStringExtra("avatar");
        countLike = getIntent().getStringExtra("countLike");
        countComment = getIntent().getIntExtra("countComment",0);
        userId = getIntent().getStringExtra("userId");
        time = getIntent().getStringExtra("time");
        isLike = getIntent().getBooleanExtra("isLike", false);


        photo_profile = (ImageView) findViewById(R.id.photo_profile);
        text_name = (TextView) findViewById(R.id.text_name);
        text_date = (TextView) findViewById(R.id.text_date);
        bt_like = (ImageButton) findViewById(R.id.bt_like);
        bt_comment = (ImageButton) findViewById(R.id.bt_comment);
        btnMore = (ImageButton) findViewById(R.id.btnMore);
        txt_like = (TextSwitcher) findViewById(R.id.txt_like);
        txt_count_comments = (TextView) findViewById(R.id.txt_count_comments);

        urlvdo = getIntent().getStringExtra("urlvdo");
        myvideoView = (VideoView) findViewById(R.id.myvideoView);

        myvideoView.setVideoPath(urlvdo);

        Picasso.with(getApplicationContext())
                .load(avatar)
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(photo_profile);
        text_name.setText(username);
        text_date.setText(time);
        txt_like.setText(countLike + " liskes");
        txt_count_comments.setText(countComment + " รายการ");
        text_date.setText(time);

        if (isLike == true) {

            bt_like.setImageResource(R.drawable.ic_heart_red);

        } else {

            bt_like.setImageResource(R.drawable.ic_heart_outline_grey);
        }


        photo_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(ActivityFullVideo.this, ActivityFriendDetails.class);
                i.putExtra("title", username);
                i.putExtra("cover", cover);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });

        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityFullVideo.this, CommentsActivity.class);
                i.putExtra("postId", postId);
                startActivity(i);
            }
        });

        bt_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickLike(postId,userIdPreferences);

            }
        });

        //play pause stop

        MediaController mediaController = new MediaController(ActivityFullVideo.this);
        mediaController.setAnchorView(myvideoView);
        myvideoView.setMediaController(mediaController);

        myvideoView.start();

    }

    private void clickLike(String post_Id, String userId) {

        ServiceApi service = Apis.getClient().create(ServiceApi.class);

        Call<PostLike> userCall = service.postLiked(post_Id, userId);

        userCall.enqueue(new Callback<PostLike>() {
            @Override
            public void onResponse(Call<PostLike> call, Response<PostLike> response) {
                Toast.makeText(getApplicationContext(), "Like " + response.body().getLikes(), Toast.LENGTH_SHORT).show();

//                updateItems();

            }

            @Override
            public void onFailure(Call<PostLike> call, Throwable t) {

            }
        });
    }




}
