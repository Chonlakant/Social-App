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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.social.ActivityFriendDetails;
import com.app.sample.social.ActivityLogin;
import com.app.sample.social.R;
import com.app.sample.social.WebActivity;
import com.app.sample.social.activity_setting.ActivitySettingAccount;
import com.app.sample.social.activity_setting.ActivitySettingNoti;
import com.app.sample.social.activity_setting.ActivitySettingPrivacy;
import com.app.sample.social.api.Apis;
import com.app.sample.social.model.Logout;
import com.app.sample.social.model.UserProfile;
import com.app.sample.social.presenter.UserProfileContract;
import com.app.sample.social.presenter.UserProfilePresenter;
import com.app.sample.social.service.ServiceApi;
import com.app.sample.social.widget.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageProfileFragment extends Fragment implements UserProfileContract.HomeViewUserProfile {
    View view;

    TextView txt_username;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";
    String userIdPreferences;
    String timeStamp;

    TextView userName;
    ImageView imagProfile;

    String title;
    String cover;
    String userId;

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

                Intent i = new Intent(getActivity(), ActivityFriendDetails.class);
                i.putExtra("title", title);
                i.putExtra("cover", cover);
                i.putExtra("userId", userId);
                startActivity(i);

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
            case R.id.lyt_noti:

                Intent intentNoti = new Intent(getActivity(), ActivitySettingNoti.class);
                startActivity(intentNoti);
                Snackbar.make(view, "Notifications", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.lyt_privcay:

                Intent intentPrivcay = new Intent(getActivity(), ActivitySettingPrivacy.class);
                startActivity(intentPrivcay);
                Snackbar.make(view, "Notifications", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.lyt_setting:

                Intent intent = new Intent(getActivity(), ActivitySettingAccount.class);
                startActivity(intent);

                Snackbar.make(view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_help:
                Intent intent1 = new Intent(getActivity(), WebActivity.class);
                startActivity(intent1);

                Snackbar.make(view, "Help nad FAQ Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.lyt_logout:
                logoutGet(userIdPreferences, timeStamp);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();

                Intent ii = new Intent(getActivity(), ActivityLogin.class);
                startActivity(ii);
                getActivity().finish();
                break;
        }
    }

    @Override
    public void showUserProfile(List<UserProfile> feed) {

        Log.e("ddddd", feed.get(0).getUser_data().getUsername());
        title = feed.get(0).getUser_data().getUsername();
        cover = feed.get(0).getUser_data().getCover();
        userId = feed.get(0).getUser_data().getUser_id();
        userName.setText(feed.get(0).getUser_data().getUsername());
        Picasso.with(getActivity())
                .load(feed.get(0)
                        .getUser_data()
                        .getAvatar())
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(imagProfile);
    }

    private void logoutGet(String userId, String timeStamp) {

        ServiceApi service = Apis.getClient().create(ServiceApi.class);

        Call<Logout> userCall = service.getLogoutUser(userId, timeStamp);

        userCall.enqueue(new Callback<Logout>() {
            @Override
            public void onResponse(Call<Logout> call, Response<Logout> response) {

            }

            @Override
            public void onFailure(Call<Logout> call, Throwable t) {

            }
        });
    }
}
