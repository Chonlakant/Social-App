package com.app.sample.social.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.activity_viedo_full.ActivityFullVideo;
import com.app.sample.social.activity_youtube.ActivityYoutube;
import com.app.sample.social.adapter.FeedListAdapter;
import com.app.sample.social.adapter.FeedListAdapter2;
import com.app.sample.social.api.ApisZaab;
import com.app.sample.social.data.Constant;
import com.app.sample.social.items.BaseItemModel;
import com.app.sample.social.items.ContentModel;
import com.app.sample.social.items.file.fileModel;
import com.app.sample.social.items.file.fileViewRenderer;
import com.app.sample.social.items.footer.CommentModel;
import com.app.sample.social.items.footer.CommentViewRenderer;
import com.app.sample.social.items.header.HeaderModel;
import com.app.sample.social.items.header.HeaderViewRenderer;
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
import com.app.sample.social.model.Feed2;
import com.app.sample.social.model.Header;
import com.app.sample.social.model.PostLike;
import com.app.sample.social.presenter.FeedContract;
import com.app.sample.social.presenter.FeedPresenter;
import com.app.sample.social.service.ServiceApiZaab;
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageFeedFragment extends Fragment implements FeedContract.HomeView, FeedListAdapter2.OnCommentClick {

    private View view;
    private RendererRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout mSwipeToRefresh;

    ArrayList<BaseItemModel> items = new ArrayList<>();

    FeedContract.HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_feed, container, false);
        setHasOptionsMenu(true);


        presenter = new FeedPresenter(this);
        presenter.getAllFeed();

        mRecyclerViewAdapter = new RendererRecyclerViewAdapter();
        mRecyclerViewAdapter.registerRenderer(new HeaderViewRenderer(HeaderModel.TYPE, getActivity()));
        mRecyclerViewAdapter.registerRenderer(new ProfileViewRenderer(ProfileModel.TYPE, getActivity(), mListenerProfile));
        mRecyclerViewAdapter.registerRenderer(new TextViewRenderer(TextModel.TYPE, getActivity(), mListenerText));
        mRecyclerViewAdapter.registerRenderer(new ImagesViewRenderer(ImagesModel.TYPE, getActivity(), mListenerPhoto));
        mRecyclerViewAdapter.registerRenderer(new VideoViewRenderer(ViedoModel.TYPE, getActivity(), mListenerVideo));
        mRecyclerViewAdapter.registerRenderer(new fileViewRenderer(fileModel.TYPE, getActivity(), mListenerfile));
        mRecyclerViewAdapter.registerRenderer(new Mp3ViewRenderer(Mp3Model.TYPE, getActivity(), mListenerMp3));
        mRecyclerViewAdapter.registerRenderer(new MapsViewRenderer(MapsModel.TYPE, getActivity(), mListenerMaps));
        mRecyclerViewAdapter.registerRenderer(new YoutubeViewRenderer(YoutubeModel.TYPE, getActivity(), mListenerYoutube));
        mRecyclerViewAdapter.registerRenderer(new SoundCloudViewRenderer(SoundCloudModel.TYPE, getActivity(), mListenerSoundCloud));
        mRecyclerViewAdapter.registerRenderer(new CommentViewRenderer(CommentModel.TYPE, getActivity(), mListenerComment));


        linearLayoutManager = new LinearLayoutManager(getActivity());


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mSwipeToRefresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        updateItems();
        return view;
    }

    private void updateItems() {

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
    public void showTitle(String title) {

    }

    @Override
    public void showMessage(String message) {

    }


    @Override
    public void showAllFeed(final List<Feed2> feed) {

        final int headerID = 1;
        String nameHeader = feed.get(0).getItems().get(0).getPublisher_data().getFirst_name();
        String avatarProFile = feed.get(0).getItems().get(0).getPublisher_data().getProfile_picture();
        String time = feed.get(0).getItems().get(0).getPost_data().getPost_time();
        items.add(new HeaderModel(headerID, nameHeader, avatarProFile, time));
        for (int i = 0; i < feed.size(); i++) {

            int type = feed.get(i).getItems().get(i).getPost_type2();
            String name = feed.get(i).getItems().get(i).getPublisher_data().getUsername();
            String avatar = feed.get(i).getItems().get(i).getPublisher_data().getProfile_picture();

            if (type == 1) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String textContent = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                String text2 = feed.get(i).getItems().get(i).getPost_data().getPost_text2();
                String html = textContent;
                String result = Html.fromHtml(html).toString();
                if (result != null) {

                    items.add(new ProfileModel(i, name, avatar, timePost));
                    items.add(new TextModel(i, result,text2));
                    items.add(new CommentModel(i, "some category #" + (i + 1)));
                }
            }
            if (type == 2) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String photoContent = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new ImagesModel(i, photoContent));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 3) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String urlMp4 = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new ViedoModel(i, urlMp4, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 4) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String urlfile = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new fileModel(i, urlfile, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 5) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String urlfile = feed.get(i).getItems().get(i).getPost_data().getPost_file();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new Mp3Model(i, urlfile, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 6) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_map();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new MapsModel(i, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

            if (type == 7) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                String cover = feed.get(i).getItems().get(i).getPost_data().getPost_thumb();
                String urlYoutube = feed.get(i).getItems().get(i).getPost_data().getPost_youtube();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new YoutubeModel(i, urlYoutube, title, cover));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }
            if (type == 8) {
                String timePost = feed.get(i).getItems().get(i).getPost_data().getPost_time();
                String title = feed.get(i).getItems().get(i).getPost_data().getPost_text();
                items.add(new ProfileModel(i, name, avatar, timePost));
                items.add(new SoundCloudModel(i, title));
                items.add(new CommentModel(i, "some category #" + (i + 1)));
            }

        }

        mRecyclerViewAdapter.setItems(items, mDiffCallback);
        mSwipeToRefresh.setRefreshing(false);

    }

    @Override
    public void onClick(Feed2 feed) {

    }

    @Override
    public void onCommentClick(View view, int position) {
        Snackbar.make(view, "Comment Clicked", Snackbar.LENGTH_SHORT).show();
    }


    @NonNull
    private final CommentViewRenderer.Listener mListenerComment = new CommentViewRenderer.Listener() {
        @Override
        public void onCommentClicked(@NonNull CommentModel model) {
            Toast.makeText(getActivity(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }

    };

    @NonNull
    private final ImagesViewRenderer.Listener mListenerPhoto = new ImagesViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ImagesModel model) {
            Toast.makeText(getActivity(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
        }

    };

    @NonNull
    private final fileViewRenderer.Listener mListenerfile = new fileViewRenderer.Listener() {
        @Override
        public void onFileClicked(@NonNull fileModel model) {

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
                Log.e("ffff",model.getUrlfifle());
        }

    };


    private final ProfileViewRenderer.Listener mListenerProfile = new ProfileViewRenderer.Listener() {
        @Override
        public void onProfileClicked(@NonNull ProfileModel model) {
            Toast.makeText(getActivity(), "gggg" + model.getID() + "", Toast.LENGTH_SHORT).show();
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


}
