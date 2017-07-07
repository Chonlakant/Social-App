package com.app.sample.social.activity_articles.activity_noti;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.R;
import com.app.sample.social.activity_comment.CommentsActivity;
import com.app.sample.social.activity_feed_mutiple_image.ActivityImageFeed;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.activity_viedo_full.ActivityFullVideo;
import com.app.sample.social.activity_youtube.ActivityYoutube;
import com.app.sample.social.adapter.ArticlesListAdapter;
import com.app.sample.social.api.Apis;
import com.app.sample.social.articles_presenter.ArticlesPresenter;
import com.app.sample.social.articles_presenter.ListArticlesContract;
import com.app.sample.social.data.Tools;
import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.items.Comment_noti.CommentListNotiViewRenderer;
import com.app.sample.social.items.Comment_noti.CommentNotiListModel;
import com.app.sample.social.items.ContentModel;
import com.app.sample.social.items.comment.CommentListModel;
import com.app.sample.social.items.comment.CommentListViewRenderer;
import com.app.sample.social.items.file.fileModel;
import com.app.sample.social.items.file.fileViewRenderer;
import com.app.sample.social.items.footer.CommentModel;
import com.app.sample.social.items.footer.CommentViewRenderer;
import com.app.sample.social.items.header.HeaderModel;
import com.app.sample.social.items.header.HeaderViewRenderer;
import com.app.sample.social.items.imageMutipleNoti.ImagesMutiNotiModel;
import com.app.sample.social.items.imageMutipleNoti.ImagesMutiNotiViewRenderer;
import com.app.sample.social.items.image_mutiple.ImagesMutiModel;
import com.app.sample.social.items.image_mutiple.ImagesMutiViewRenderer;
import com.app.sample.social.items.images.ImagesModel;
import com.app.sample.social.items.images.ImagesViewRenderer;
import com.app.sample.social.items.maps.MapsModel;
import com.app.sample.social.items.maps.MapsViewRenderer;
import com.app.sample.social.items.mp3.Mp3Model;
import com.app.sample.social.items.mp3.Mp3ViewRenderer;
import com.app.sample.social.items.profile.ProfileModel;
import com.app.sample.social.items.profile.ProfileViewRenderer;
import com.app.sample.social.items.soundcloud.SoundCloudModel;
import com.app.sample.social.items.soundcloud.SoundCloudViewRenderer;
import com.app.sample.social.items.text.TextModel;
import com.app.sample.social.items.text.TextViewRenderer;
import com.app.sample.social.items.viedo.VideoViewRenderer;
import com.app.sample.social.items.viedo.ViedoModel;
import com.app.sample.social.items.youtube.YoutubeModel;
import com.app.sample.social.items.youtube.YoutubeViewRenderer;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.GetPostId;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.model_articles.ArticlesList;
import com.app.sample.social.post_timeline.ActivityPostTimeline;
import com.app.sample.social.presenter.GetFeedNotiPostIdContract;
import com.app.sample.social.presenter.GetFeedNotiPostIdPresenter;
import com.app.sample.social.service.ServiceApi;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityNoti extends AppCompatActivity implements GetFeedNotiPostIdContract.HomeViewPostNotiId {


    private RendererRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    GetFeedNotiPostIdContract.HomePostNotiIdPresenter presenter;

    public static ArticlesListAdapter adapter;

    ArrayList<BaseItemModel> items = new ArrayList<>();
    private RecyclerView recyclerViewDetails;

    private ActionBar actionBar;
    private View parent_view;

    String userIdPreferences;
    String timeStamp;
    String postId;

    String postType;

    String name;
    String avatar;
    String userId;
    String cover;

    ArrayList<String> arrImage = new ArrayList<String>();

    ArrayList<Feed.PostsBean.GetPostCommentsBean> l = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");


        mRecyclerViewAdapter = new RendererRecyclerViewAdapter();

        mRecyclerViewAdapter.registerRenderer(new ProfileViewRenderer(ProfileModel.TYPE, ActivityNoti.this, mListenerProfile));
        mRecyclerViewAdapter.registerRenderer(new TextViewRenderer(TextModel.TYPE, ActivityNoti.this, mListenerText));
        mRecyclerViewAdapter.registerRenderer(new ImagesViewRenderer(ImagesModel.TYPE, ActivityNoti.this, mListenerImage));
        mRecyclerViewAdapter.registerRenderer(new ImagesMutiNotiViewRenderer(ImagesMutiNotiModel.TYPE, ActivityNoti.this, mListenerMutiPhoto));
        mRecyclerViewAdapter.registerRenderer(new VideoViewRenderer(ViedoModel.TYPE, ActivityNoti.this, mListenerVideo));
        mRecyclerViewAdapter.registerRenderer(new fileViewRenderer(fileModel.TYPE, ActivityNoti.this, mListenerfile));
        mRecyclerViewAdapter.registerRenderer(new Mp3ViewRenderer(Mp3Model.TYPE, ActivityNoti.this, mListenerMp3));
        mRecyclerViewAdapter.registerRenderer(new MapsViewRenderer(MapsModel.TYPE, ActivityNoti.this, mListenerMaps));
        mRecyclerViewAdapter.registerRenderer(new YoutubeViewRenderer(YoutubeModel.TYPE, ActivityNoti.this, mListenerYoutube));
        mRecyclerViewAdapter.registerRenderer(new SoundCloudViewRenderer(SoundCloudModel.TYPE, ActivityNoti.this, mListenerSoundCloud));
        mRecyclerViewAdapter.registerRenderer(new CommentViewRenderer(CommentModel.TYPE, ActivityNoti.this, mListenerComment, mListenerLike));
        mRecyclerViewAdapter.registerRenderer(new CommentListNotiViewRenderer(CommentNotiListModel.TYPE, ActivityNoti.this, mListenerListComment));


        parent_view = findViewById(android.R.id.content);

        postType = getIntent().getStringExtra("post_type");
        postId = getIntent().getStringExtra("post_id");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDetails);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ActivityNoti.this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        initToolbar();


        presenter = new GetFeedNotiPostIdPresenter(this);
        presenter.getAllPostIdFeedNoti(userIdPreferences, postId, timeStamp, "1");


        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    private void updateItems() {

        items.clear();
        presenter = new GetFeedNotiPostIdPresenter(this);
        presenter.getAllPostIdFeedNoti(userIdPreferences, postId, timeStamp, "1");

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
        mRecyclerViewAdapter.notifyDataSetChanged();

        if (postType.equals("comment")) {

            for (int i = 0; i < feed.size(); i++) {
                int type = feed.get(i).getPost_data().getPost_type2();

                name = feed.get(i).getPost_data().getPublisher().getUsername();
                avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                cover = feed.get(i).getPost_data().getPublisher().getCover();


                if (type == 1) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    Log.e("photoContent", photoContent);

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new TextModel(i, textContent, postId));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 2) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    String userName = feed.get(i).getPost_data().getPublisher().getUsername();
                    String avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ImagesModel(i, photoContent, postId,userName,avatar,is_liked,timePost,countLike,countComment));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 3) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlMp4 = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ViedoModel(i, urlMp4, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 4) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new fileModel(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 5) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new Mp3Model(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 6) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostMap();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new MapsModel(i, photoContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 7) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostLinkTitle();
                    String coverYoutube = feed.get(i).getPost_data().getPostLinkImage();
                    String urlYoutube = feed.get(i).getPost_data().getPostLink();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new YoutubeModel(i, urlYoutube, title, coverYoutube));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 8) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostSoundCloud();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new SoundCloudModel(i, title));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }


                if (type == 22) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String ii = "https://www.zaab-d.com/upload/photos/2017/06/1azi9cp99MHYXHRfgubQ_18_7e5a2f752367d74642bb85a6fcb66ba7_image.jpg";
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    if (feed.get(i).getPost_data().getPhoto_multi() != null) {

                        items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                        items.add(new ImagesMutiNotiModel(i, ii, postId, feed.get(i).getPost_data().getPhoto_multi(), textContent));
                        items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                        items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                    }


                }

            }
        }

        if (postType.equals("liked_post")) {

            for (int i = 0; i < feed.size(); i++) {
                int type = feed.get(i).getPost_data().getPost_type2();
                Log.e("liked_post",type+"");
                name = feed.get(i).getPost_data().getPublisher().getUsername();
                avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                cover = feed.get(i).getPost_data().getPublisher().getCover();


                if (type == 1) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    Log.e("photoContent", photoContent);

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new TextModel(i, textContent, postId));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 2) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String userName = feed.get(i).getPost_data().getPublisher().getUsername();
                    String avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                    arrImage.add(photoContent);
                    Log.e("photoContent", photoContent);
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ImagesModel(i, photoContent, postId,userName,avatar,is_liked,timePost,countLike,countComment));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 3) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlMp4 = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ViedoModel(i, urlMp4, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 4) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new fileModel(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 5) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new Mp3Model(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 6) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostMap();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new MapsModel(i, photoContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 7) {

                    Toast.makeText(getApplicationContext(),"dddd",Toast.LENGTH_SHORT).show();
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostLinkTitle();
                    String coverYoutube = feed.get(i).getPost_data().getPostLinkImage();
                    String urlYoutube = feed.get(i).getPost_data().getPostLink();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new YoutubeModel(i, urlYoutube, title, coverYoutube));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 8) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostSoundCloud();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new SoundCloudModel(i, title));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }


                if (type == 22) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String ii = "https://www.zaab-d.com/upload/photos/2017/06/1azi9cp99MHYXHRfgubQ_18_7e5a2f752367d74642bb85a6fcb66ba7_image.jpg";
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    if (feed.get(i).getPost_data().getPhoto_multi() != null) {

                        items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                        items.add(new ImagesMutiNotiModel(i, ii, postId, feed.get(i).getPost_data().getPhoto_multi(), textContent));
                        items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                        items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                    }


                }

            }

        }

        if (postType.equals("comment_reply")) {


            for (int i = 0; i < feed.size(); i++) {
                int type = feed.get(i).getPost_data().getPost_type2();

                name = feed.get(i).getPost_data().getPublisher().getUsername();
                avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                cover = feed.get(i).getPost_data().getPublisher().getCover();


                if (type == 1) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    Log.e("photoContent", photoContent);

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new TextModel(i, textContent, postId));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 2) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String userName = feed.get(i).getPost_data().getPublisher().getUsername();
                    String avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                    arrImage.add(photoContent);
                    Log.e("photoContent", photoContent);
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ImagesModel(i, photoContent, postId,userName,avatar,is_liked,timePost,countLike,countComment));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 3) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlMp4 = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ViedoModel(i, urlMp4, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 4) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new fileModel(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 5) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new Mp3Model(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 6) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostMap();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new MapsModel(i, photoContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 7) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostLinkTitle();
                    String coverYoutube = feed.get(i).getPost_data().getPostLinkImage();
                    String urlYoutube = feed.get(i).getPost_data().getPostLink();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new YoutubeModel(i, urlYoutube, title, coverYoutube));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 8) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostSoundCloud();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new SoundCloudModel(i, title));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }


                if (type == 22) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    String ii = "https://www.zaab-d.com/upload/photos/2017/06/1azi9cp99MHYXHRfgubQ_18_7e5a2f752367d74642bb85a6fcb66ba7_image.jpg";

                    if (feed.get(i).getPost_data().getPhoto_multi() != null) {

                        items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                        items.add(new ImagesMutiNotiModel(i, ii, postId, feed.get(i).getPost_data().getPhoto_multi(), textContent));
                        items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                        items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                    }


                }

            }

        }

        if (postType.equals("profile_wall_post")) {
            for (int i = 0; i < feed.size(); i++) {
                int type = feed.get(i).getPost_data().getPost_type2();

                name = feed.get(i).getPost_data().getPublisher().getUsername();
                avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                cover = feed.get(i).getPost_data().getPublisher().getCover();


                if (type == 1) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    String avatar = feed.get(i).getPost_data().getPublisher().getAvatar();
                    Log.e("photoContent", photoContent);

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new TextModel(i, textContent, postId));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 2) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    String userName = feed.get(i).getPost_data().getPublisher().getUsername();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ImagesModel(i, photoContent, postId,userName,avatar,is_liked,timePost,countLike,countComment));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 3) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlMp4 = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ViedoModel(i, urlMp4, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 4) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new fileModel(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 5) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostFile_full();
                    String urlfile = feed.get(i).getPost_data().getPostFile_full();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new Mp3Model(i, urlfile, textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 6) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String photoContent = feed.get(i).getPost_data().getPostMap();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new MapsModel(i, photoContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 7) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostLinkTitle();
                    String coverYoutube = feed.get(i).getPost_data().getPostLinkImage();
                    String urlYoutube = feed.get(i).getPost_data().getPostLink();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new YoutubeModel(i, urlYoutube, title, coverYoutube));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }

                if (type == 8) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String title = feed.get(i).getPost_data().getPostSoundCloud();
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new SoundCloudModel(i, title));
                    items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                    items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                }


                if (type == 22) {
                    boolean is_liked = feed.get(i).getPost_data().isIs_liked();
                    String countLike = feed.get(i).getPost_data().getPost_likes();
                    String textContent = feed.get(i).getPost_data().getPostText();
                    String timePost = feed.get(i).getPost_data().getPost_time();
                    String ii = "https://www.zaab-d.com/upload/photos/2017/06/1azi9cp99MHYXHRfgubQ_18_7e5a2f752367d74642bb85a6fcb66ba7_image.jpg";
                    int countComment = feed.get(i).getPost_data().getGet_post_comments().size();
                    if (feed.get(i).getPost_data().getPhoto_multi() != null) {

                        items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                        items.add(new ImagesMutiNotiModel(i, ii, postId, feed.get(i).getPost_data().getPhoto_multi(), textContent));
                        items.add(new CommentModel(i, countLike, is_liked, postId,countComment));
                        items.add(new CommentNotiListModel(i, feed.get(i).getPost_data().getGet_post_comments()));
                    }


                }

            }
        }



        Log.e("postType",postType);
        mRecyclerViewAdapter.setItems(items, mDiffCallback);
        mRecyclerViewAdapter.notifyDataSetChanged();


    }


    @NonNull
    private final HeaderViewRenderer.Listener mListenerHeaderText = new HeaderViewRenderer.Listener() {
        @Override
        public void onTextClicked(@NonNull HeaderModel model) {

            Intent i = new Intent(getApplicationContext(), ActivityPostTimeline.class);
            startActivity(i);
        }

    };


    @NonNull
    private final CommentViewRenderer.Listener mListenerComment = new CommentViewRenderer.Listener() {
        @Override
        public void onCommentClicked(@NonNull CommentModel model) {

            Intent i = new Intent(getApplicationContext(), CommentsActivity.class);
            i.putExtra("postId", model.getPostId());
            startActivity(i);
        }

    };

    @NonNull
    private final CommentListNotiViewRenderer.Listener mListenerListComment = new CommentListNotiViewRenderer.Listener() {
        @Override
        public void onCommentClicked(@NonNull CommentListModel model) {

        }

    };

    @NonNull
    private final CommentViewRenderer.ListenerLike mListenerLike = new CommentViewRenderer.ListenerLike() {
        @Override
        public void onLikeClicked(@NonNull CommentModel model) {
            clickLike(model.getPostId(), userIdPreferences);


        }

    };



    @NonNull
    private final ImagesMutiNotiViewRenderer.Listener mListenerMutiPhoto = new ImagesMutiNotiViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ImagesMutiNotiModel model) {
            Toast.makeText(getApplicationContext(), "gggg" + "", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), ActivityMutiImageFeed.class);
            i.putExtra("postId", model.getPostId());
            startActivity(i);
        }

    };


    @NonNull
    private final ImagesViewRenderer.ListeneImage mListenerImage = new ImagesViewRenderer.ListeneImage() {
        @Override
        public void onLikeImageked(@NonNull ImagesModel model) {
            Toast.makeText(getApplicationContext(), "Check Image" + model.getPostId(), Toast.LENGTH_SHORT).show();


            Intent i = new Intent(getApplicationContext(), ActivityImageFeed.class);
            i.putExtra("array_list", model.getUrlConntent());
            i.putExtra("avatar",model.getAvatarUrl());
            i.putExtra("username",model.getUsername());
            i.putExtra("postId",model.getPostId());
            i.putExtra("isLike",model.isLike());
            i.putExtra("time",model.getTime());
            i.putExtra("countLike",model.getCountLike());
            i.putExtra("countComment",model.getCountComment());
            startActivity(i);

        }
    };

    @NonNull
    private final fileViewRenderer.Listener mListenerfile = new fileViewRenderer.Listener() {
        @Override
        public void onFileClicked(@NonNull fileModel model) {


            Toast.makeText(getApplicationContext(), "Download File...", Toast.LENGTH_SHORT).show();

            String DownloadUrl = model.getUrlfifle();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
            request.setDescription("sample pdf file for testing");   //appears the same in Notification bar while downloading
            request.setTitle(model.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }
            request.setDestinationInExternalFilesDir(getApplicationContext(), null, model.getTitle());

            // get download service and enqueue file
            DownloadManager manager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);

        }

    };

    @NonNull
    private final VideoViewRenderer.Listener mListenerVideo = new VideoViewRenderer.Listener() {
        @Override
        public void onPlayClicked(@NonNull ViedoModel model) {

            String post_file = model.getUrlViedo();
            Intent i = new Intent(getApplicationContext(), ActivityFullVideo.class);
            i.putExtra("urlvdo", post_file);
            startActivity(i);
        }

    };


    @NonNull
    private final TextViewRenderer.Listener mListenerText = new TextViewRenderer.Listener() {
        @Override
        public void onTextClicked(@NonNull TextModel model) {

        }


    };

    @NonNull
    private final MapsViewRenderer.Listener mListenerMaps = new MapsViewRenderer.Listener() {
        @Override
        public void onMpasClicked(@NonNull MapsModel model) {

        }

    };

    @NonNull
    private final Mp3ViewRenderer.Listener mListenerMp3 = new Mp3ViewRenderer.Listener() {
        @Override
        public void onPlayClicked(@NonNull Mp3Model model) {

        }

    };


    private final ProfileViewRenderer.Listener mListenerProfile = new ProfileViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ProfileModel model) {

            String title = model.getName();
            String cover = model.getCover();
            String userId = model.getUserId();

            Log.e("title", title);
            Log.e("cover", cover);
            Log.e("userId", userId);

            Intent i = new Intent(getApplicationContext(), ActivityFriendDetails.class);
            i.putExtra("title", title);
            i.putExtra("cover", cover);
            i.putExtra("userId", userId);
            startActivity(i);
        }


    };

    private final YoutubeViewRenderer.Listener mListenerYoutube = new YoutubeViewRenderer.Listener() {
        @Override
        public void onYoutubeClicked(@NonNull YoutubeModel model) {

            String s = model.getUrlYoutube();
            String[] parts = s.split("\\="); // escape .
            String part1 = parts[0];
            final String part2 = parts[1];


            Intent i = new Intent(getApplicationContext(), ActivityYoutube.class);
            i.putExtra("urlYoutube", part2);
            startActivity(i);
        }

    };

    private final SoundCloudViewRenderer.Listener mListenerSoundCloud = new SoundCloudViewRenderer.Listener() {
        @Override
        public void onSoundCloudClicked(@NonNull SoundCloudModel model) {


        }

    };

    @NonNull
    private final RendererRecyclerViewAdapter.DiffCallback<BaseItemModel> mDiffCallback = new RendererRecyclerViewAdapter
            .DiffCallback<BaseItemModel>() {
        @Override
        public boolean areItemsTheSame(final BaseItemModel oldItem, final BaseItemModel newItem) {
            return oldItem.getID() == newItem.getID();
        }

        @Override
        public boolean areContentsTheSame(final BaseItemModel oldItem, final BaseItemModel newItem) {
            return oldItem.equals(newItem);
        }

        @Nullable
        @Override
        public Object getChangePayload(final BaseItemModel oldItem, final BaseItemModel newItem) {
            if (oldItem.getType() != ContentModel.TYPE ||
                    newItem.getType() != ContentModel.TYPE) {
                return null;
            }

            final ContentModel oldContentItem = (ContentModel) oldItem;
            final ContentModel newContentItem = (ContentModel) newItem;

            final Bundle diffBundle = new Bundle();
            if (!oldContentItem.getName().equals(newContentItem.getName())) {
                diffBundle.putBoolean(ContentModel.KEY_NAME, true);
            }

            return diffBundle.size() == 0 ? null : diffBundle;
        }
    };

    private void clickLike(String post_Id, String userId) {

        ServiceApi service = Apis.getClient().create(ServiceApi.class);

        Call<PostLike> userCall = service.postLiked(post_Id, userId);

        userCall.enqueue(new Callback<PostLike>() {
            @Override
            public void onResponse(Call<PostLike> call, Response<PostLike> response) {
                Toast.makeText(getApplicationContext(), "Like " + response.body().getLikes(), Toast.LENGTH_SHORT).show();

                updateItems();

            }

            @Override
            public void onFailure(Call<PostLike> call, Throwable t) {

            }
        });
    }
}
