package com.app.sample.social.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
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

    GetAlbumIdContract.HomePostAlbumIdPresenter homePostAlbumIdPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend_photos, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("userId", "null");


        homePostAlbumIdPresenter = new GetAlbumIdPresenter(this);
        homePostAlbumIdPresenter.getAllPostIdAlbum(userIdPreferences, userIdPreferences, timeStamp, "100", "1");

        LinearLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Tools.getGridSpanCount(getActivity()));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void showAllAlbumId(List<Album> feed) {

        mAdapter = new AlbumGridAdapter(getActivity(), feed);
        recyclerView.setAdapter(mAdapter);

    }
}
