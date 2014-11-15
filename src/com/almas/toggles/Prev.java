package com.almas.toggles;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;

public class Prev extends TogglePower {

	public Prev(Context context) {
		super(context);
		
	}

	@Override
	public void onToggleClick() {
		MusicControl mc = new MusicControl();
		mc.sendMediaKeyEvent(getContext(), KeyEvent.KEYCODE_MEDIA_PREVIOUS);
	}

	@Override
	public void onToggleLongClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel() {
		return "Prev";
	}

	@Override
	public boolean getStatus() {
		return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tPrev);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Prev();
	}

	@Override
	public Drawable getIconOff() {
		return am.Prev();
	}
}
