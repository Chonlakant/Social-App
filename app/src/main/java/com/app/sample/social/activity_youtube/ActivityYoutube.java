package com.app.sample.social.activity_youtube;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.Config;
import com.app.sample.social.R;
import com.app.sample.social.activity_comment.CommentsActivity;
import com.app.sample.social.activity_viedo_full.ActivityFullVideo;
import com.app.sample.social.api.Apis;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.service.ServiceApi;
import com.app.sample.social.widget.CircleTransform;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityYoutube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;
    private YouTubePlayer player;

    String urlYoutube;

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
        setContentView(R.layout.activity_youtube);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");
        Log.e("userIdPreferences", userIdPreferences);

        urlYoutube = getIntent().getStringExtra("urlYoutube");
//        Log.e("urlYoutube",urlYoutube);

        photo_profile = (ImageView) findViewById(R.id.photo_profile);
        text_name = (TextView) findViewById(R.id.text_name);
        text_date = (TextView) findViewById(R.id.text_date);
        bt_like = (ImageButton) findViewById(R.id.bt_like);
        bt_comment = (ImageButton) findViewById(R.id.bt_comment);
        btnMore = (ImageButton) findViewById(R.id.btnMore);
        txt_like = (TextSwitcher) findViewById(R.id.txt_like);
        txt_count_comments = (TextView) findViewById(R.id.txt_count_comments);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        username = getIntent().getStringExtra("username");
        cover = getIntent().getStringExtra("cover");
        postId = getIntent().getStringExtra("postId");
        avatar = getIntent().getStringExtra("avatar");
        countLike = getIntent().getStringExtra("countLike");
        countComment = getIntent().getIntExtra("countComment",0);
        userId = getIntent().getStringExtra("userId");
        time = getIntent().getStringExtra("time");
        isLike = getIntent().getBooleanExtra("isLike", false);



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


                Intent i = new Intent(ActivityYoutube.this, ActivityFriendDetails.class);
                i.putExtra("title", username);
                i.putExtra("cover", cover);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });

        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityYoutube.this, CommentsActivity.class);
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

        playerStateChangeListener = new MyPlayerStateChangeListener();
        playbackEventListener = new MyPlaybackEventListener();

    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored) {
            player.cueVideo(urlYoutube); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
         //   player.loadVideo(urlYoutube);
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            //Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    private void showMessage(String message) {
       // Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }

    private void clickLike(String post_Id, String userId) {

        ServiceApi service = Apis.getClient().create(ServiceApi.class);

        Call<PostLike> userCall = service.postLiked(post_Id, userId);

        userCall.enqueue(new Callback<PostLike>() {
            @Override
            public void onResponse(Call<PostLike> call, Response<PostLike> response) {
                Toast.makeText(getApplicationContext(), "Like " + response.body().getLikes(), Toast.LENGTH_SHORT).show();


                Log.e("getLikes",response.body().getLikes());

            }

            @Override
            public void onFailure(Call<PostLike> call, Throwable t) {

            }
        });
    }

}
