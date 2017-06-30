package com.app.sample.social.activity_comment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.presenter.GetFeedPostCommentIdContract;
import com.app.sample.social.presenter.GetFeedPostCommentIdPresenter;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity implements GetFeedPostCommentIdContract.HomeViewPostId  {
    public static final String ARG_DRAWING_START_LOCATION = "arg_drawing_start_location";

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";


    LinearLayout contentRoot;
    RecyclerView rvComments;
    LinearLayout llAddComment;
    EditText etComment;
    Button btnSendComment;

    private CommentsAdapter commentsAdapter;

    GetFeedPostCommentIdContract.HomePostIdPresenter homePostIdPresenter;

    String userIdPreferences;
    String timeStamp;
    String postId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        postId = getIntent().getStringExtra("postId");

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");

        homePostIdPresenter = new GetFeedPostCommentIdPresenter(this);
        homePostIdPresenter.getAllPostCommentIdFeed(userIdPreferences,postId,timeStamp,"1");


        contentRoot = (LinearLayout) findViewById(R.id.contentRoot);
        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        llAddComment = (LinearLayout) findViewById(R.id.llAddComment);
        etComment = (EditText) findViewById(R.id.etComment);
        btnSendComment = (Button) findViewById(R.id.btnSendComment);

        setupComments();

    }

    private void setupComments() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvComments.setLayoutManager(linearLayoutManager);
        rvComments.setHasFixedSize(true);

        commentsAdapter = new CommentsAdapter(this);
        rvComments.setAdapter(commentsAdapter);
        rvComments.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rvComments.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    commentsAdapter.setAnimationsLocked(true);
                }
            }
        });
    }


    private void animateContent() {
        commentsAdapter.updateItems();
        llAddComment.animate().translationY(0)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(200)
                .start();
    }

    @Override
    public void showAllCommentPostId(List<GetPostId> feed) {


    }

    @Override
    public void showCommentArr(ArrayList<String> listStr) {

    }
}
