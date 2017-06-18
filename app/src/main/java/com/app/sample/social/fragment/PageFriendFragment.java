package com.app.sample.social.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.ActivityFriendDetails2;
import com.app.sample.social.ActivityMain;
import com.app.sample.social.R;
import com.app.sample.social.adapter.FriendsListAdapter;
import com.app.sample.social.adapter.FriendsListAdapter2;
import com.app.sample.social.data.Constant;
import com.app.sample.social.model.Friend;
import com.app.sample.social.model.Friend2;
import com.app.sample.social.presenter.FeedPresenter;
import com.app.sample.social.presenter.FriendsListUserPresenter;
import com.app.sample.social.presenter.ListFriendsUserContract;

import java.util.List;

public class PageFriendFragment extends Fragment implements ListFriendsUserContract.HomeViewFriendsUser {

    private RecyclerView recyclerView;
    private FriendsListAdapter2 mAdapter;
    private View view;
    private SearchView search;
    ListFriendsUserContract.HomePresenterFriendsUser presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_friend, container, false);

        // activate fragment menu
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //set data and list adapter
//        mAdapter = new FriendsListAdapter2(getActivity(), Constant.getFriendsData(getActivity()));
//        recyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(new FriendsListAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, Friend obj, int position) {
//                ActivityFriendDetails.navigate((ActivityMain) getActivity(), v, obj);
//            }
//        });

        presenter = new FriendsListUserPresenter(this);
        presenter.getAllFriendsUser("1");
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_friend, menu);
        search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setIconified(false);
        search.setQueryHint("Search Friend...");
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                try {
                    mAdapter.getFilter().filter(s);
                } catch (Exception e) {
                }
                return true;
            }
        });
        search.onActionViewCollapsed();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_friend:
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
    public void showAllFriendsUser(final List<Friend2> feed) {
        mAdapter = new FriendsListAdapter2(getActivity(), feed);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new FriendsListAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Friend2 obj, int position) {
              // ActivityFriendDetails.navigate((ActivityMain) getActivity(), view, obj);
                String title = feed.get(position).getUsers().get(position).getName();
                String cover = feed.get(position).getUsers().get(position).getCover_picture();
                String userId = feed.get(position).getUsers().get(position).getUser_id();
                Intent i = new Intent(getActivity(),ActivityFriendDetails.class);
                i.putExtra("title",title);
                i.putExtra("cover",cover);
                i.putExtra("userId",userId);
                startActivity(i);
            }
        });
    }
}
