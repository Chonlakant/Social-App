package com.app.sample.social.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.R;
import com.app.sample.social.activity_noti.ActivityNoti;
import com.app.sample.social.adapter.NotifListAdapter;
import com.app.sample.social.model.Notifications;
import com.app.sample.social.notifications_presenter.NotiUserContract;
import com.app.sample.social.notifications_presenter.NotiUserPresenter;

import java.util.List;

public class PageNotifFragment extends Fragment implements NotiUserContract.HomeViewNotoUsers {

    private RecyclerView recyclerView;
    private View view;
    private NotifListAdapter mAdapter;

    NotiUserContract.HomePresenterNotiUser presenter;

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";


    String userIdPreferences;
    String timeStamp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_notif, container, false);

        // activate fragment menu
        setHasOptionsMenu(true);

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        presenter = new NotiUserPresenter(this);
        presenter.notiUser(userIdPreferences, timeStamp);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_notif, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Snackbar.make(view, item.getTitle() + " Clicked", Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void notiUser(final List<Notifications> notificationsList) {

        //set data and list adapter
        mAdapter = new NotifListAdapter(getActivity(), notificationsList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new NotifListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String post_id = notificationsList.get(position).getNotifications().get(position).getPost_id();
                String type = notificationsList.get(position).getNotifications().get(position).getType();
                if (type.equals("visited_profile")) {

                    String userId = notificationsList.get(position).getNotifications().get(position).getNotifier().getUser_id();
                    String cover = notificationsList.get(position).getNotifications().get(position).getNotifier().getCover();
                    String title = notificationsList.get(position).getNotifications().get(position).getNotifier().getName();

                    Intent i = new Intent(getActivity(), ActivityFriendDetails.class);
                    i.putExtra("userId", userId);
                    i.putExtra("cover", cover);
                    i.putExtra("title", title);
                    startActivity(i);
                    Toast.makeText(getActivity(), "Check", Toast.LENGTH_SHORT).show();
                }
                if (type.equals("comment")) {

                    Intent i = new Intent(getActivity(), ActivityNoti.class);
                    i.putExtra("post_id", post_id);
                    i.putExtra("post_type", "comment");
                    startActivity(i);

                }
                if (type.equals("profile_wall_post")) {
                    Intent i = new Intent(getActivity(), ActivityNoti.class);
                    i.putExtra("post_id", post_id);
                    i.putExtra("post_type", "profile_wall_post");
                    startActivity(i);
                }
                if (type.equals("liked_post")) {

                    Intent i = new Intent(getActivity(), ActivityNoti.class);
                    i.putExtra("post_id", post_id);
                    i.putExtra("post_type", "liked_post");
                    startActivity(i);
                }
                if (type.equals("comment_reply")) {
                    Intent i = new Intent(getActivity(), ActivityNoti.class);
                    i.putExtra("post_id", post_id);
                    i.putExtra("post_type", "comment");
                    startActivity(i);
                }

            }
        });

    }
}
