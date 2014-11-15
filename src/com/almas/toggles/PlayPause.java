package com.almas.toggles;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.view.KeyEvent;

public class PlayPause extends TogglePower {
	AudioManager mg;
	public PlayPause(Context context) {
		super(context);
		MusicControl mc = new MusicControl();
		 mg = mc.getAudioManager(getContext());
	}

	@Override
	public void onToggleClick() {
		MusicControl mc = new MusicControl();
		mc.sendMediaKeyEvent(getContext(), KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
	}

	@Override
	public void onToggleLongClick() {
		
		
	}

	@Override
	public String getLabel() {
		return getStatus()?"Pause":"Play";
	}


	@Override
	public boolean getStatus() {
		return mg.isMusicActive();
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tPP);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Play(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Play(false);
	}

}
