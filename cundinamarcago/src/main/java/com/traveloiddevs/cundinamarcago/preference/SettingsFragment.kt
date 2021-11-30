package com.traveloiddevs.cundinamarcago.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.traveloiddevs.cundinamarcago.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}