package com.app.sample.social.fragment;

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
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.R;
import com.app.sample.social.activity_comment.CommentsActivity;
import com.app.sample.social.activity_feed_mutiple_image.ActivityImageFeed;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.activity_viedo_full.ActivityFullVideo;
import com.app.sample.social.activity_youtube.ActivityYoutube;
import com.app.sample.social.api.Apis;
import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.items.ContentModel;
import com.app.sample.social.items.comment.CommentListModel;
import com.app.sample.social.items.comment.CommentListViewRenderer;
import com.app.sample.social.items.file.fileModel;
import com.app.sample.social.items.file.fileViewRenderer;
import com.app.sample.social.items.footer.CommentModel;
import com.app.sample.social.items.footer.CommentViewRenderer;
import com.app.sample.social.items.header.HeaderModel;
import com.app.sample.social.items.header.HeaderViewRenderer;
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
import com.app.sample.social.model.ObjectImageMutiple;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.post_timeline.ActivityPostTimeline;
import com.app.sample.social.presenter.FeedContract;
import com.app.sample.social.presenter.FeedPresenter;
import com.app.sample.social.service.ServiceApi;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageFeedFragment extends Fragment implements FeedContract.HomeView {


    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    private View view;
    private RendererRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipeToRefresh;

    ArrayList<BaseItemModel> items = new ArrayList<>();


    FeedContract.HomePresenter presenter;


    int type;
    String name;
    String avatar;
    String userId;
    String cover;

    String postId;

    String userIdPreferences;
    String timeStamp;


    ArrayList<String> arrImage = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_feed, container, false);
        setHasOptionsMenu(true);

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");
        Log.e("userIdPreferences", userIdPreferences);

        presenter = new FeedPresenter(this);
        presenter.getAllFeed(userIdPreferences, userIdPreferences, timeStamp, "30");


        mRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        mRecyclerViewAdapter.registerRenderer(new HeaderViewRenderer(HeaderModel.TYPE, getActivity(), mListenerHeaderText));
        mRecyclerViewAdapter.registerRenderer(new ProfileViewRenderer(ProfileModel.TYPE, getActivity(), mListenerProfile));
        mRecyclerViewAdapter.registerRenderer(new TextViewRenderer(TextModel.TYPE, getActivity(), mListenerText));
        mRecyclerViewAdapter.registerRenderer(new ImagesViewRenderer(ImagesModel.TYPE, getActivity(), mListenerPhoto, mListenerImage));
        mRecyclerViewAdapter.registerRenderer(new ImagesMutiViewRenderer(ImagesMutiModel.TYPE, getActivity(), mListenerMutiPhoto));
        mRecyclerViewAdapter.registerRenderer(new VideoViewRenderer(ViedoModel.TYPE, getActivity(), mListenerVideo));
        mRecyclerViewAdapter.registerRenderer(new fileViewRenderer(fileModel.TYPE, getActivity(), mListenerfile));
        mRecyclerViewAdapter.registerRenderer(new Mp3ViewRenderer(Mp3Model.TYPE, getActivity(), mListenerMp3));
        mRecyclerViewAdapter.registerRenderer(new MapsViewRenderer(MapsModel.TYPE, getActivity(), mListenerMaps));
        mRecyclerViewAdapter.registerRenderer(new YoutubeViewRenderer(YoutubeModel.TYPE, getActivity(), mListenerYoutube));
        mRecyclerViewAdapter.registerRenderer(new SoundCloudViewRenderer(SoundCloudModel.TYPE, getActivity(), mListenerSoundCloud));
        mRecyclerViewAdapter.registerRenderer(new CommentViewRenderer(CommentModel.TYPE, getActivity(), mListenerComment, mListenerLike));
        mRecyclerViewAdapter.registerRenderer(new CommentListViewRenderer(CommentListModel.TYPE, getActivity(), mListenerListComment));


        linearLayoutManager = new LinearLayoutManager(getActivity());


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mSwipeToRefresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        mSwipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });


        return view;
    }

    private void updateItems() {

        items.clear();
        presenter.getAllFeed(userIdPreferences, userIdPreferences, timeStamp, "20");
        mRecyclerViewAdapter.notifyDataSetChanged();

    }

    void refreshItems() {

        onItemsLoadComplete();
    }

    void onItemsLoadComplete() {
        items.clear();
        presenter.getAllFeed(userIdPreferences, userIdPreferences, timeStamp, "20");
        mRecyclerViewAdapter.notifyDataSetChanged();
        mSwipeToRefresh.setRefreshing(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_feed, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_feed:
                Snackbar.make(view, item.getTitle() + " Clicked", Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void showAllFeed(final List<Feed> feed, ArrayList<ObjectImageMutiple> objectImageMutiples) {
        mRecyclerViewAdapter.notifyDataSetChanged();


            final int headerID = 1;
            String nameHeader = feed.get(0).getPosts().get(0).getPublisher_data().getFirst_name();
            String avatarProFile = feed.get(0).getPosts().get(0).getPublisher_data().getProfile_picture();
            String time = feed.get(0).getPosts().get(0).getPost_data().getPost_time();
            items.add(new HeaderModel(headerID, nameHeader, avatarProFile, time));


        for (int i = 0; i < feed.size(); i++) {

            type = feed.get(i).getPosts().get(i).getPost_type2();
            Log.e("type", type + "");
            name = feed.get(i).getPosts().get(i).getPublisher_data().getUsername();
            avatar = feed.get(i).getPosts().get(i).getPublisher_data().getProfile_picture();
            userId = feed.get(i).getPosts().get(i).getPublisher_data().getId();
            cover = feed.get(i).getPosts().get(i).getPublisher_data().getCover_picture();

            if (type == 1) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String text2 = feed.get(i).getPosts().get(i).getPost_data().getPost_text2();

                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new TextModel(i, textContent, text2));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));


                for (int j = 0; j < feed.get(i).getPosts().get(i).getGet_post_comments().size(); j++) {
                    Log.e("ggggg", feed.get(i).getPosts().get(i).getGet_post_comments().get(j).getText() + "");
                }


            }
            if (type == 2) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String photoContent = feed.get(i).getPosts().get(i).getPost_data().getPost_thumb();

//                for(int j = 0 ; j < feed.get(i).getPosts().get(i).getPhoto_multi().size();j++){
//
//                    String image = feed.get(j).getPosts().get(j).getPhoto_multi().get(j).getImage();
//                    Log.e("image",image);
//                }

                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new ImagesModel(i, photoContent, postId));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));

                arrImage.add(photoContent);


            }

            if (type == 22) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String ii = "https://www.zaab-d.com/upload/photos/2017/06/1azi9cp99MHYXHRfgubQ_18_7e5a2f752367d74642bb85a6fcb66ba7_image.jpg";
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String photoContent = feed.get(i).getPosts().get(i).getPost_data().getPost_thumb();

                Log.e("textContent", textContent);


                if (feed.get(i).getPosts().get(i).getPhoto_multi() != null) {

                    items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                    items.add(new ImagesMutiModel(i, ii, postId, feed.get(i).getPosts().get(i).getPhoto_multi(), textContent));
                    items.add(new CommentModel(i, countLike, is_liked, postId));
                    items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
                }


            }
            if (type == 3) {
                postId = feed.get(i).getPosts().get(i).getPost_id();
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String urlMp4 = feed.get(i).getPosts().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new ViedoModel(i, urlMp4, title));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }

            if (type == 4) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String urlfile = feed.get(i).getPosts().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new fileModel(i, urlfile, title));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }

            if (type == 5) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String urlfile = feed.get(i).getPosts().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new Mp3Model(i, urlfile, title));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }
            if (type == 6) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_map();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new MapsModel(i, title));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }

            if (type == 7) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String coverYoutube = feed.get(i).getPosts().get(i).getPost_data().getPost_thumb();
                String urlYoutube = feed.get(i).getPosts().get(i).getPost_data().getPost_youtube();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new YoutubeModel(i, urlYoutube, title, coverYoutube));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }
            if (type == 8) {
                boolean  is_liked = feed.get(i).getPosts().get(i).isIs_liked();
                postId = feed.get(i).getPosts().get(i).getPost_id();
                String countLike = feed.get(i).getPosts().get(i).getPost_data().getPost_likes();
                String textContent = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                String timePost = feed.get(i).getPosts().get(i).getPost_time();
                String title = feed.get(i).getPosts().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost, userId, cover));
                items.add(new SoundCloudModel(i, title));
                items.add(new CommentModel(i, countLike, is_liked, postId));
                items.add(new CommentListModel(i, feed.get(i).getPosts().get(i).getGet_post_comments()));
            }

        }


        mRecyclerViewAdapter.setItems(items, mDiffCallback);
        mSwipeToRefresh.setRefreshing(false);
        mRecyclerViewAdapter.notifyDataSetChanged();

    }

    @NonNull
    private final HeaderViewRenderer.Listener mListenerHeaderText = new HeaderViewRenderer.Listener() {
        @Override
        public void onTextClicked(@NonNull HeaderModel model) {

            Intent i = new Intent(getActivity(), ActivityPostTimeline.class);
            startActivity(i);
        }

    };


    @NonNull
    private final CommentViewRenderer.Listener mListenerComment = new CommentViewRenderer.Listener() {
        @Override
        public void onCommentClicked(@NonNull CommentModel model) {

            Intent i = new Intent(getActivity(), CommentsActivity.class);
            i.putExtra("postId", model.getPostId());
            startActivity(i);
        }

    };

    @NonNull
    private final CommentListViewRenderer.Listener mListenerListComment = new CommentListViewRenderer.Listener() {
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
    private final ImagesViewRenderer.Listener mListenerPhoto = new ImagesViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ImagesModel model) {

            Toast.makeText(getContext(), "Check Image" + model.getPostId(), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getActivity(), ActivityImageFeed.class);
            i.putExtra("array_list", arrImage);
            startActivity(i);
        }

        ;
    };

    @NonNull
    private final ImagesMutiViewRenderer.Listener mListenerMutiPhoto = new ImagesMutiViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ImagesMutiModel model) {


            Toast.makeText(getActivity(), "gggg" + "", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getActivity(), ActivityMutiImageFeed.class);
            i.putExtra("postId", model.getPostId());
            startActivity(i);

        }

    };


    @NonNull
    private final ImagesViewRenderer.ListeneImage mListenerImage = new ImagesViewRenderer.ListeneImage() {
        @Override
        public void onLikeImageked(@NonNull ImagesModel model) {
            Toast.makeText(getContext(), "Check Image" + model.getPostId(), Toast.LENGTH_SHORT).show();


            Intent i = new Intent(getActivity(), ActivityImageFeed.class);
            i.putExtra("array_list", arrImage);
            startActivity(i);

        }
    };

    @NonNull
    private final fileViewRenderer.Listener mListenerfile = new fileViewRenderer.Listener() {
        @Override
        public void onFileClicked(@NonNull fileModel model) {


            Toast.makeText(getActivity(), "Download File...", Toast.LENGTH_SHORT).show();

            String DownloadUrl = model.getUrlfifle();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
            request.setDescription("sample pdf file for testing");   //appears the same in Notification bar while downloading
            request.setTitle(model.getTitle());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }
            request.setDestinationInExternalFilesDir(getActivity(), null, model.getTitle());

            // get download service and enqueue file
            DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);

        }

    };

    @NonNull
    private final VideoViewRenderer.Listener mListenerVideo = new VideoViewRenderer.Listener() {
        @Override
        public void onPlayClicked(@NonNull ViedoModel model) {

            String post_file = model.getUrlViedo();
            Intent i = new Intent(getActivity(), ActivityFullVideo.class);
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

            Intent i = new Intent(getActivity(), ActivityFriendDetails.class);
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


            Intent i = new Intent(getActivity(), ActivityYoutube.class);
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
                Toast.makeText(getContext(), "Like " + response.body().getLikes(), Toast.LENGTH_SHORT).show();

                updateItems();

            }

            @Override
            public void onFailure(Call<PostLike> call, Throwable t) {

            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();

    }
}
