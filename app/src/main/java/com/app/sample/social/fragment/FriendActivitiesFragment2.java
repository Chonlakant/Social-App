package com.app.sample.social.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.R;
import com.app.sample.social.adapter.FeedUserListAdapter;
import com.app.sample.social.model.FeedUser;
import com.app.sample.social.model.Header;
import com.app.sample.social.presenter.FeedUserContract;
import com.app.sample.social.presenter.FeedUserPresenter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ResourceType")
public class FriendActivitiesFragment2 extends Fragment implements FeedUserContract.HomeViewUser{

    String userId;

    public static FriendActivitiesFragment2 getInstance(String userId) {
        FriendActivitiesFragment2 mainFragment = new FriendActivitiesFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("MSG", userId);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    private RecyclerView recyclerView;
    private FeedUserListAdapter mAdapter;

    FeedUserContract.HomePresenterUser presenter;


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       //userId = getActivity().getIntent().getStringExtra("MSG");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_activities, null);
      //  userId = getActivity().getIntent().getStringExtra("MSG");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setHasFixedSize(true);

        Bundle args = getArguments();
        userId = args.getString("MSG");

        presenter = new FeedUserPresenter(this);
        presenter.getAllFeedUser(userId);

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

    public Header getHeader() {
        Header header = new Header();
        header.setHeader("I'm header");
        return header;
    }

    @Override
    public void showAllFeedUser(List<FeedUser> feed) {
        mAdapter = new FeedUserListAdapter(getActivity(), feed,getHeader());
        recyclerView.setAdapter(mAdapter);
    }
}
