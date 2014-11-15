package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class ScreenTimeout extends TogglePower {

	public ScreenTimeout(Context context) {
		super(context);
	}

	@Override
	public void onToggleClick() {
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.window.TimeoutWindow");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getContext().startActivity(i);
		
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
		return "Screen Timeout";
	}

	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tST);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Timeout(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Timeout(false);
	}

}
