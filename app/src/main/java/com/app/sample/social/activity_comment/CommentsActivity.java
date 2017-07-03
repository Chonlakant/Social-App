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
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.ObjectComment;
import com.app.sample.social.model.PostComment;
import com.app.sample.social.post_comment_presenter.PostCommentContract;
import com.app.sample.social.post_comment_presenter.PostCommentPresenter;
import com.app.sample.social.presenter.GetFeedPostCommentIdContract;
import com.app.sample.social.presenter.GetFeedPostCommentIdPresenter;
import com.app.sample.social.presenter.GetFeedPostIdContract;
import com.app.sample.social.presenter.GetFeedPostIdPresenter;

import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity implements GetFeedPostCommentIdContract.HomeViewPostId, PostCommentContract.HomeViewPostComment {
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
    PostCommentContract.HomePresenterPostComment presenterPostComment;

    String userIdPreferences;
    String timeStamp;
    String postId;
    ArrayList<ObjectComment> listComment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        postId = getIntent().getStringExtra("postId");

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");

        homePostIdPresenter = new GetFeedPostCommentIdPresenter(this);
        homePostIdPresenter.getAllPostCommentIdFeed(userIdPreferences, postId, timeStamp, "100");

        presenterPostComment = new PostCommentPresenter(this);


        contentRoot = (LinearLayout) findViewById(R.id.contentRoot);
        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        llAddComment = (LinearLayout) findViewById(R.id.llAddComment);
        etComment = (EditText) findViewById(R.id.etComment);
        btnSendComment = (Button) findViewById(R.id.btnSendComment);

        setupComments();

        btnSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterPostComment.postText(userIdPreferences, timeStamp, etComment.getText().toString(), postId);
            }
        });

    }

    private void setupComments() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvComments.setLayoutManager(linearLayoutManager);
        rvComments.setHasFixedSize(true);


    }


    @Override
    public void showAllCommentPostId(List<GetPostId> feed) {


    }

    @Override
    public void showCommentArr(ArrayList<ObjectComment> listStr) {
        listComment = listStr;
        commentsAdapter = new CommentsAdapter(getApplicationContext(), listComment);
        rvComments.setAdapter(commentsAdapter);
        rvComments.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    @Override
    public void postComment(List<PostComment> postText) {

        if (postText.get(0).getApi_status().equals("200")) {
            Toast.makeText(getApplicationContext(), "POST COMPLETE", Toast.LENGTH_SHORT).show();
            listComment.clear();
            homePostIdPresenter.getAllPostCommentIdFeed(userIdPreferences, postId, timeStamp, "1");
            commentsAdapter.notifyDataSetChanged();
            etComment.setText("");

        } else {
            Toast.makeText(getApplicationContext(), "POST ERROR", Toast.LENGTH_SHORT).show();
        }

    }
}
