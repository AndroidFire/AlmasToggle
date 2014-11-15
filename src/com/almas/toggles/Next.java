package com.almas.toggles;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;

public class Next extends TogglePower {

	public Next(Context context) {
		super(context);
		
	}

	@Override
	public void onToggleClick() {
		MusicControl mc = new MusicControl();
		mc.sendMediaKeyEvent(getContext(), KeyEvent.KEYCODE_MEDIA_NEXT);
	}

	@Override
	public void onToggleLongClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel() {
		return "Next";
	}

	@Override
	public boolean getStatus() {
		return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tNext);		
	}

	@Override
	public Drawable getIconOn() {
		return am.Next();
	}

	@Override
	public Drawable getIconOff() {
		return am.Next();
	}
}
