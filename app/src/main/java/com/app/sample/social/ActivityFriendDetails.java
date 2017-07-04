package com.app.sample.social;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.app.sample.social.fragment.FriendAboutFragment;
import com.app.sample.social.fragment.FriendActivitiesFragment;
import com.app.sample.social.fragment.FriendPhotosFragment;
import com.app.sample.social.model.Friend;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ActivityFriendDetails extends AppCompatActivity {
    public static final String EXTRA_OBJCT = "com.app.sample.social.FRIEND2";

    // give preparation animation activity transition
//    public static void navigate(AppCompatActivity activity, View transitionImage, Friend2 obj) {
//        Intent intent = new Intent(activity, ActivityFriendDetails.class);
//        intent.putExtra(EXTRA_OBJCT, obj);
//        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_OBJCT);
//        ActivityCompat.startActivity(activity, intent, options.toBundle());
//    }

    private ViewPager mViewPager;
    private FriendAboutFragment frag_friendAbout;
    private FriendActivitiesFragment frag_friendActivity;
    private FriendPhotosFragment frag_friendPhotos;
    private ActionBar actionBar;
    public static Friend friend;
    String title;
    String cover;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_details);

        // animation transition
        ViewCompat.setTransitionName(findViewById(android.R.id.content), EXTRA_OBJCT);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        title = getIntent().getStringExtra("title");
        cover = getIntent().getStringExtra("cover");
        userId = getIntent().getStringExtra("userId");
        Log.e("userId", userId);
        // get extra object
        friend = (Friend) getIntent().getSerializableExtra(EXTRA_OBJCT);

        // scollable toolbar
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title);
        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        //  ivImage.setImageResource(friend.getPhoto());
        Glide.with(getApplicationContext())
                .load(cover)
                .into(ivImage);


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        if (frag_friendAbout == null) {
            frag_friendAbout = FriendAboutFragment.getInstance(userId);
        }
        if (frag_friendActivity == null) {
            frag_friendActivity = FriendActivitiesFragment.getInstance(userId);
        }
        if (frag_friendPhotos == null) {
            frag_friendPhotos = FriendPhotosFragment.getInstance(userId);
        }

        adapter.addFragment(frag_friendActivity, "ACTIVITIES");
        adapter.addFragment(frag_friendPhotos, "PHOTOS");
        adapter.addFragment(frag_friendAbout, "ABOUT");

        mViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (item.getItemId() == R.id.action_add_friends) {
//            Intent i = new Intent(getApplicationContext(), ActivityChatDetails.class);
//            i.putExtra(ActivityChatDetails.KEY_FRIEND, friend);
//            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_friend_details, menu);
        return true;
    }


    static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
