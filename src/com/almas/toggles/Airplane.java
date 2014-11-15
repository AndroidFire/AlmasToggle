package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Log;
@SuppressWarnings("deprecation")
public class Airplane extends TogglePower {
	public Airplane(Context context) {

		super(context);
		Log.d(tag, "Me on Airplane");
	}

	@Override
	public void onToggleClick() {
	
	Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
	intent.putExtra("state", !getStatus());
	Log.d(tag, "Putting State opposite to current state");
	getContext().sendBroadcast(intent);
	Settings.System.putInt(getContext().getContentResolver(), Settings.System.AIRPLANE_MODE_ON, getStatus()?0:1);
		
	}

	@Override
	public void onToggleLongClick() {
		Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "Airplane";
	}



	@Override
	public boolean getStatus() {
		return Settings.System.getInt(getContext().getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON,0) == 1;
	}
	@Override
	public void onUpdate() {

	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tAir);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Airplane(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Airplane(false);
	}

}
