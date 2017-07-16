package com.app.sample.social.activity_setting;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.sample.social.R;
import com.app.sample.social.data.Tools;

public class ActivitySettingNoti extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_setting);

        initToolbar();
        // for system bar in lollipop
        Tools.systemBarLolipop(this);
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new MyPreferenceNotiFragment()).commit();
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Notifications");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle(friend.getHtml().get(0).getName());
    }
}
