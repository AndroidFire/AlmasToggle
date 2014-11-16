package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;

public class Rotage extends TogglePower {

	public Rotage(Context context) {
		super(context);

	}

	@Override
	public void onToggleClick() {
		android.provider.Settings.System.putInt(getContext().getContentResolver(),Settings.System.ACCELEROMETER_ROTATION, getStatus()?0:1);
		
		
	}

	@Override
	public void onToggleLongClick() {
		  Intent intent = new Intent("android.settings.DISPLAY_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
	}

	@Override
	public String getLabel() {
		return "Auto Rotation";
	}


	@Override
	public boolean getStatus() {
		return Settings.System.getInt(
                getContext().getContentResolver(),
                Settings.System.ACCELEROMETER_ROTATION, 0)==1;
	}
	@Override
	public void onUpdate() {
	
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), "AutoRotate");
	}

	@Override
	public Drawable getIconOn() {
		return am.Rotation(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Rotation(false);
	}
}
