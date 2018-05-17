package com.example.bjg70.example;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

public class Setting_Preference extends PreferenceFragment {

    SharedPreferences preferences;

    PreferenceScreen messagePreference;
    PreferenceScreen soundPreference;
    ListPreference developerPreference;
    ListPreference helpPreference;

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        addPreferencesFromResource(R.xml.settings_preference);
        messagePreference = (PreferenceScreen)findPreference("message_alarm");
        soundPreference = (PreferenceScreen)findPreference("sound_alarm");
        developerPreference = (ListPreference) findPreference("developer_information");
        helpPreference = (ListPreference) findPreference("help_book");

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

    }// onCreate

}
