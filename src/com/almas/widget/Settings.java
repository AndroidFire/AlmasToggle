package com.almas.widget;

import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.almas.toggles.R;
@SuppressWarnings("deprecation")
public class Settings extends PreferenceActivity {
	CheckBoxPreference HideonChange;
	ListPreference policy;
	ListPreference num;
	int b;
	int c;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.set);
		b = android.provider.Settings.System.getInt(getContentResolver(), "AlmasToggle",0);

		c = android.provider.Settings.System.getInt(getContentResolver(), "AlmasToggleHC",0);
		
	
		HideonChange = (CheckBoxPreference) findPreference("toggleg");
		policy = (ListPreference) findPreference("pol");
		num = (ListPreference) findPreference("toggle_col");
		
		
		if (b == 1 ) {
			num.setEnabled(true);
		}
		else {
			num.setEnabled(false);
		}
		policy.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference arg0, Object arg1) {
				String Vis = (String.valueOf(arg1));
			
				if (Vis.equalsIgnoreCase("GridView")) {
					android.provider.Settings.System.putInt(getContentResolver(), "AlmasTogglePolicy",1);
					Intent i =  new Intent();
					i.setAction("com.almas.UPDATE");
					sendBroadcast(i);
					num.setEnabled(true);
				}
				else {
					android.provider.Settings.System.putInt(getContentResolver(), "AlmasTogglePolicy",0);
					Intent i =  new Intent();
					i.setAction("com.almas.UPDATE");
					sendBroadcast(i);
					num.setEnabled(false);
				}
				return true;
			}
		});
		num.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference arg0, Object arg1) {
				String si = (String.valueOf(arg1));
				int s = (Integer.parseInt(si));
					Intent i =  new Intent();
					i.setAction("com.almas.UPDATE_GRIDVIEW");
					i.putExtra("Column", ""+s);
					sendBroadcast(i);
				
				return true;
				
			}
		});

		if (HideonChange.isChecked()) {
			android.provider.Settings.System.putInt(getContentResolver(), "AlmasToggleHC",1);
			 
		}
		else {
			android.provider.Settings.System.putInt(getContentResolver(), "AlmasToggleHC",0);
			
		}
	}
}
