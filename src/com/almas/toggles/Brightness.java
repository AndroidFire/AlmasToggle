package com.almas.toggles;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class Brightness extends TogglePower {

	public Brightness(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onToggleClick() {
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.window.BrightnessWindow");
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
		return "Brightness";
	}

	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tBr);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Brithness();
	}

	@Override
	public Drawable getIconOff() {
		return am.Brithness();
	}


}
