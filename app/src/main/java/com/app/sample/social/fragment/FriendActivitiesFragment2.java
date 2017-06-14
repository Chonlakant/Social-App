package com.app.sample.social.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.adapter.FeedUserListAdapter;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.presenter.FeedUserContract;
import com.app.sample.social.presenter.FeedUserPresenter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ResourceType")
public class FriendActivitiesFragment2 extends Fragment implements FeedUserContract.HomeViewUser{

    private RecyclerView recyclerView;
    private FeedUserListAdapter mAdapter;

    FeedUserContract.HomePresenterUser presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_activities, null);



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setHasFixedSize(true);

        presenter = new FeedUserPresenter(this);
        presenter.getAllFeedUser();

        return view;
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
    public void showAllFeedUser(List<FeedUser> feed) {
        mAdapter = new FeedUserListAdapter(getActivity(), feed);
        recyclerView.setAdapter(mAdapter);
    }
}
