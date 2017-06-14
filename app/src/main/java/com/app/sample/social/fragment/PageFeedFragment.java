package com.app.sample.social.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.app.sample.social.adapter.FeedListAdapter;
import com.app.sample.social.adapter.FeedListAdapter2;
import com.app.sample.social.data.Constant;
import com.app.sample.social.model.Feed;
import com.app.sample.social.model.Feed2;
import com.app.sample.social.presenter.FeedContract;
import com.app.sample.social.presenter.FeedPresenter;

import java.util.ArrayList;
import java.util.List;

public class PageFeedFragment extends Fragment implements FeedContract.HomeView {

    private View view;
    private ProgressBar progressbar;
    private RecyclerView recyclerView;
    // private FeedListAdapter mAdapter;

    private FeedListAdapter2 mAdapter;


    FeedContract.HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_feed, container, false);
        // activate fragment menu
        setHasOptionsMenu(true);

        progressbar = (ProgressBar) view.findViewById(R.id.progressbar);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setHasFixedSize(true);
        if (!taskRunning) {
            //new DummyFeedLoader().execute("");
        }

        presenter = new FeedPresenter(this);
        presenter.getAllFeed();


        return view;
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

    private boolean taskRunning = false;

    @Override
    public void showLoading() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showTitle(String title) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showAllFeed(List<Feed2> feed) {
        Log.e("Check", feed.get(0).getPosts().get(0).getPost_type() + "");

        mAdapter = new FeedListAdapter2(getActivity(), feed);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickLike(new FeedListAdapter2.OnItemClickLike() {
            @Override
            public void onItemClickLike(View view, int position) {
                Snackbar.make(view, "Like Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        mAdapter.SetOnPhotoClick(new FeedListAdapter2.OnPhotoClick() {
            @Override
            public void onPhotoClick(View view, int position) {
                Snackbar.make(view, "Click Photo", Snackbar.LENGTH_SHORT).show();
            }
        });

        mAdapter.SetOnCommentClick(new FeedListAdapter2.OnCommentClick() {
            @Override
            public void onCommentClick(View view, int position) {
                Snackbar.make(view, "Comment Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        mAdapter.SetOnShareClick(new FeedListAdapter2.OnShareClick() {
            @Override
            public void onShareClick(View view, int position) {
                Snackbar.make(view, "Share Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

        mAdapter.SetOnMoreClick(new FeedListAdapter2.OnMoreClick() {
            @Override
            public void onMoreClick(View view, int position) {
                Snackbar.make(view, "More Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(Feed2 feed) {

    }


    private class DummyFeedLoader extends AsyncTask<String, String, String> {
        private String status = "";
        private List<Feed> items = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            taskRunning = true;
            items.clear();
            progressbar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(500);
                items = Constant.getRandomFeed(getActivity());
                status = "success";
            } catch (Exception e) {
                status = "failed";
            }
            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            progressbar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            if (status.equals("success")) {
                //set data and list adapter
                //   mAdapter = new FeedListAdapter(getActivity(), items);
                // recyclerView.setAdapter(mAdapter);
            }
            taskRunning = false;
            super.onProgressUpdate(values);
        }
    }


}
