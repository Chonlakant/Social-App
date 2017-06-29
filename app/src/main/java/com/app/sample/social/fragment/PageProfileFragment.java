package com.app.sample.social.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.UserProfile;
import com.app.sample.social.presenter.UserProfileContract;
import com.app.sample.social.presenter.UserProfilePresenter;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PageProfileFragment extends Fragment implements UserProfileContract.HomeViewUserProfile {
    View view;

    TextView txt_username;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";
    String userIdPreferences;
    String timeStamp;

    TextView userName;
    ImageView imagProfile;

    UserProfileContract.HomePresenteUserProfile presenteUserProfile;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_profile, container, false);

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");
        Log.e("userIdPreferences", userIdPreferences);
        Log.e("timeStamp", timeStamp);

        userName = (TextView) view.findViewById(R.id.txt_username);
        imagProfile = (ImageView) view.findViewById(R.id.img_profile);


        presenteUserProfile = new UserProfilePresenter(this);
        presenteUserProfile.getAllUserProfile(userIdPreferences, userIdPreferences, timeStamp);



        return view;
    }

    public void actionClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_view_profile:
                Snackbar.make(view, "View Profile Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_group_cat:
                Snackbar.make(view, "Group - Cat Lover Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_group_hangout:
                Snackbar.make(view, "Group - Hangout Friend Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_group_collage:
                Snackbar.make(view, "Group - Collage Clicked", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.lyt_setting:
                Snackbar.make(view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_help:
                Snackbar.make(view, "Help nad FAQ Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_logout:
                Snackbar.make(view, "Logout Clicked", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void showUserProfile(List<UserProfile> feed) {

        Log.e("ddddd", feed.get(0).getUser_data().getUsername());
        userName.setText(feed.get(0).getUser_data().getUsername());
        Picasso.with(getActivity())
                .load(feed.get(0)
                .getUser_data()
                .getAvatar())
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(imagProfile);
    }
}
