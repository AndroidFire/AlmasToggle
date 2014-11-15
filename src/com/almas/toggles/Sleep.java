package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.os.SystemClock;

public class Sleep extends TogglePower {

	public Sleep(Context context) {
		super(context);

	}

	@Override
	public void onToggleClick() {
		 PowerManager pm = (PowerManager) getContext().getSystemService(Context.POWER_SERVICE);
         pm.goToSleep(SystemClock.uptimeMillis() + 1);
		
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
		return "Sleep";
	}
	@Override
	public boolean getStatus() {
		return false;
	}
	@Override
	public void onUpdate() {

	}

	@Override
	public void onTogglerObserver() {
		
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tSleep);
	}

	@Override
	public Drawable getIconOn() {
		return am.Sleep();
	}

	@Override
	public Drawable getIconOff() {
		return am.Sleep();
	}
}
