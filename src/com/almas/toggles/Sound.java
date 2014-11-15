package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;

public class Sound extends TogglePower {

	public Sound(Context context) {
		super(context);
		
	}

	@Override
	public void onToggleClick() {
		AudioManager audioManager = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
		if (getSoundMode() == 0 ) {
			audioManager.setRingerMode(2);
		}
		else if (getSoundMode() == 2 ) {
			audioManager.setRingerMode(0);
		}
		
	}

	@Override
	public void onToggleLongClick() {
		  Intent intent = new Intent("android.settings.SOUND_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "Sound";
	}


	@Override
	public boolean getStatus() {
		 AudioManager audioManager = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
		if (audioManager.getRingerMode() == 0 ) {
			return false;
		}
		else if (audioManager.getRingerMode() == 2 ) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getSoundMode() {
		AudioManager audioManager = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
		return audioManager.getRingerMode();
	}
	@Override
	public void onUpdate() {

	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tSo);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Sound(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Sound(false);
	}
}
