package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class Eatter extends TogglePower {

	public Eatter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onToggleClick() {
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.window.EatterWindow");
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
		return "Eatter";
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tEat);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Eatter();
	}

	@Override
	public Drawable getIconOff() {
		return am.Eatter();
	}

}
