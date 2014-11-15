package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class Screenshot extends TogglePower {

	public Screenshot(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onToggleClick() {
		 Intent intent = new Intent("com.sec.android.app.screencapture.capture");
         intent.addCategory("android.intent.category.DEFAULT");
         getContext().startService(intent);
		
	}

	@Override
	public void onToggleLongClick() {
		
		
	}

	@Override
	public String getLabel() {
		return "Screenshot";
	}

	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tSc);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.SS();
	}

	@Override
	public Drawable getIconOff() {
		return am.SS();
	}

}
