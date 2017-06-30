package com.app.sample.social.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sample.social.R;
import com.app.sample.social.model.UserProfile;
import com.app.sample.social.presenter.UserProfileContract;
import com.app.sample.social.presenter.UserProfilePresenter;

import java.util.List;

public class FriendAboutFragment extends Fragment implements UserProfileContract.HomeViewUserProfile{

    UserProfileContract.HomePresenteUserProfile presenteUserProfile;

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";
    String userIdPreferences;
    String timeStamp;

    String userId;

    TextView tv_email;
    TextView tv_gender;
    TextView tv_language;

    public static FriendAboutFragment getInstance(String userId) {
        FriendAboutFragment mainFragment = new FriendAboutFragment();
        Bundle bundle = new Bundle();
        bundle.putString("MSG", userId);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_about, null);

        tv_email = (TextView) view.findViewById(R.id.tv_email);
        tv_gender = (TextView) view.findViewById(R.id.tv_gender);
        tv_language = (TextView) view.findViewById(R.id.tv_language);

        Bundle args = getArguments();
        userId = args.getString("MSG");

        sharedpreferences = getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");
        Log.e("userIdPreferences", userIdPreferences);
        Log.e("timeStamp", timeStamp);
        Log.e("userId", userId);

        presenteUserProfile = new UserProfilePresenter(this);
        presenteUserProfile.getAllUserProfile(userIdPreferences, userIdPreferences, timeStamp);

        return view;
    }

    @Override
    public void showUserProfile(List<UserProfile> feed) {

        tv_email.setText(feed.get(0).getUser_data().getEmail());
        tv_gender.setText(feed.get(0).getUser_data().getGender_text());
        tv_language.setText(feed.get(0).getUser_data().getLanguage());

    }
}
