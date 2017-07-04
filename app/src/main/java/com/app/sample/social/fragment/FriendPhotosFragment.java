package com.app.sample.social.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.sample.social.R;
import com.app.sample.social.activity_feed_mutiple_image.ActivityAlbumMutiImageFeed;
import com.app.sample.social.activity_feed_mutiple_image.ActivityMutiImageFeed;
import com.app.sample.social.adapter.AlbumGridAdapter;
import com.app.sample.social.album_presenter.GetAlbumIdContract;
import com.app.sample.social.album_presenter.GetAlbumIdPresenter;
import com.app.sample.social.data.Constant;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model.Album;

import java.util.List;

public class FriendPhotosFragment extends Fragment implements GetAlbumIdContract.HomeViewAlbumId {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    private RecyclerView recyclerView;
    public AlbumGridAdapter mAdapter;
    private View view;
    String userIdPreferences;
    String timeStamp;

    String userId;

    GetAlbumIdContract.HomePostAlbumIdPresenter homePostAlbumIdPresenter;


    public static FriendPhotosFragment getInstance(String userId) {
        FriendPhotosFragment mainFragment = new FriendPhotosFragment();
        Bundle bundle = new Bundle();
        bundle.putString("MSG", userId);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend_photos, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");

        Bundle args = getArguments();
        userId = args.getString("MSG");

        homePostAlbumIdPresenter = new GetAlbumIdPresenter(this);
        homePostAlbumIdPresenter.getAllPostIdAlbum(userId, userId, timeStamp, "100", "1");

        LinearLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Tools.getGridSpanCount(getActivity()));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void showAllAlbumId(final List<Album> feed) {

        mAdapter = new AlbumGridAdapter(getActivity(), feed);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AlbumGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "gggg" + "", Toast.LENGTH_SHORT).show();
                Log.e("post_id",feed.get(position).getPosts().get(position).getPost_id());
                Intent i = new Intent(getActivity(), ActivityAlbumMutiImageFeed.class);
                i.putExtra("postId", feed.get(position).getPosts().get(position).getPost_id());
                startActivity(i);
            }
        });

    }
}
