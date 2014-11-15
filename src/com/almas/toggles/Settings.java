package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class Settings extends TogglePower {

	public Settings(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onToggleClick() {
		Intent i = new Intent();
		i.setClassName("com.android.settings", "com.android.settings.Settings");
		i.addCategory(Intent.CATEGORY_DEFAULT);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getContext().startActivity(i);
		
	}

	@Override
	public void onToggleLongClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel() {
		return "Settings";
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), "Settings");
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Settings();
	}

	@Override
	public Drawable getIconOff() {
		return am.Settings();
	}

}
