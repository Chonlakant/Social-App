package com.app.sample.social.activity_setting;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.app.sample.social.R;

/**
 * Created by Bas on 7/15/2017 AD.
 */

public class MyPreferenceNotiFragment extends PreferenceFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_notification);
    }
}