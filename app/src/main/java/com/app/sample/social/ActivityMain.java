package com.app.sample.social;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.app.sample.social.activity_articles.ActivityArticles;
import com.app.sample.social.adapter.PageFragmentAdapter;
import com.app.sample.social.api.Apis;
import com.app.sample.social.data.Constant;
import com.app.sample.social.data.Tools;
import com.app.sample.social.fragment.PageFeedFragment;
import com.app.sample.social.fragment.PageFriendFragment;
import com.app.sample.social.fragment.PageMessageFragment;
import com.app.sample.social.fragment.PageNotifFragment;
import com.app.sample.social.fragment.PageProductFragment;
import com.app.sample.social.fragment.PageProfileFragment;
import com.app.sample.social.model.Logout;
import com.app.sample.social.service.ServiceApi;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityMain extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private View parent_view;

    private PageFragmentAdapter adapter;

    private PageFeedFragment f_feed;
    private PageFriendFragment f_friend;
    private PageProductFragment f_message;
    private PageNotifFragment f_notif;
    private PageProfileFragment f_profile;
    private static int[] imageResId = {
            R.drawable.tab_feed,
            R.drawable.tab_friend,
            R.drawable.tab_chat,
            R.drawable.tab_notif,
            R.drawable.tab_profile
    };

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";

    String timeStamp;
    String username;
    boolean checkLogin;
    String userIdPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(android.R.id.content);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        timeStamp = sharedpreferences.getString("timeStamp", "null");
        username = sharedpreferences.getString("userName", "null");
        checkLogin = sharedpreferences.getBoolean("isLogin", false);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        Log.e("timeStamp",timeStamp);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        setupTabClick();


        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PageFragmentAdapter(getSupportFragmentManager());
        if (f_feed == null) {
            f_feed = new PageFeedFragment();
        }
        if (f_friend == null) {
            f_friend = new PageFriendFragment();
        }
        if (f_message == null) {
            f_message = new PageProductFragment();
        }
        if (f_notif == null) {
            f_notif = new PageNotifFragment();
        }
        if (f_profile == null) {
            f_profile = new PageProfileFragment();
        }
        adapter.addFragment(f_feed, getString(R.string.tab_feed));
        adapter.addFragment(f_friend, getString(R.string.tab_friend));
        adapter.addFragment(f_message, getString(R.string.tab_message));
        adapter.addFragment(f_notif, getString(R.string.tab_notif));
        adapter.addFragment(f_profile, getString(R.string.tab_profile));
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(imageResId[0]);
        tabLayout.getTabAt(1).setIcon(imageResId[1]);
        tabLayout.getTabAt(2).setIcon(imageResId[2]);
        tabLayout.getTabAt(3).setIcon(imageResId[3]);
        tabLayout.getTabAt(4).setIcon(imageResId[4]);
    }

    private void setupTabClick() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
                actionbar.setTitle(adapter.getTitle(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("About");
                builder.setMessage(getString(R.string.about_text));
                builder.setNeutralButton("OK", null);
                builder.show();
                return true;
            }
            case R.id.action_articles: {
                Intent i = new Intent(getApplicationContext(), ActivityArticles.class);
                startActivity(i);
                return true;
            }
            case R.id.action_login: {
                Intent i = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(i);
                return true;
            }
            case R.id.action_settings: {
                Snackbar.make(parent_view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_regist: {
                Intent i = new Intent(getApplicationContext(), ActivityRegistration.class);
                startActivity(i);
                return true;
            }
            case R.id.action_louout: {


                logoutGet(userIdPreferences, timeStamp);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();

                Intent i = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(i);
                finish();

                return true;
            }


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
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

    @Override
    public void onBackPressed() {
        doExitApp();
    }


    // handle click profile page
    public void actionClick(View view) {
        f_profile.actionClick(view);
    }
}
