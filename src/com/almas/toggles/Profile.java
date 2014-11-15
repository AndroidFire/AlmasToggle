package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;

public class Profile extends TogglePower {
	String imageuri;
	String title;
	long lastClick = System.currentTimeMillis();
	int clicks;
	public Profile(Context context) {
		super(context);
		imageuri = Settings.System.getString(getContext().getContentResolver(), "AlmasPhoto" );
		title = Settings.System.getString(getContext().getContentResolver(), "AlmasName" );
		
		if (title == "" ) {
			Settings.System.putString(getContext().getContentResolver(), "AlmasName", "Profile");
		}
		
		if (imageuri == null ) {
		
		}
		else  {
		
		}
		
	}

	@Override
	public void onToggleClick() {
		if (lastClick + 3000 >= System.currentTimeMillis()) {
			clicks++;
			lastClick = System.currentTimeMillis();
		} else {
			lastClick = System.currentTimeMillis();
			clicks = 1;
		}
		if (clicks == 3) {
			
		}
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.window.ProfileWindow");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getContext().startActivity(i);
	}

	@Override
	public void onToggleLongClick() {
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.window.ProfileWindow");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getContext().startActivity(i);
		
	}

	@Override
	public String getLabel() {
		if (Settings.System.getString(getContext().getContentResolver(), "AlmasName" ) == null) {
			return "Profile";
		}
		else {
			return Settings.System.getString(getContext().getContentResolver(), "AlmasName" );
		}
		
	}


	@Override
	public boolean getStatus() {
	  return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tPro);
	}

	@Override
	public Drawable getIconOn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Drawable getIconOff() {
		// TODO Auto-generated method stub
		return null;
	}



}
