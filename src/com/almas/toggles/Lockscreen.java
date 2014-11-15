package com.almas.toggles;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;

@SuppressWarnings("deprecation")
public class Lockscreen extends TogglePower {
	private KeyguardLock mLock = null;
	 KeyguardManager keyguardManager;
	public Lockscreen(Context context) {
		super(context);
		  keyguardManager = (KeyguardManager)
                 context.getSystemService(Context.KEYGUARD_SERVICE);
		  mLock = keyguardManager.newKeyguardLock("PowerWidget");
	}


	@Override
	public void onToggleClick() {
		onLock(getStatus()?false:true);
	}
	public void onLock(boolean b) {
		if (b == true ) {
			mLock.disableKeyguard();
			Settings.System.putInt(getContext().getContentResolver(), "AlmasLockscreen", 1);
		}
		else if (b == false ) {
			mLock.reenableKeyguard();
			Settings.System.putInt(getContext().getContentResolver(), "AlmasLockscreen", 0);
		}
	}

	@Override
	public void onToggleLongClick() {
		 Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "Lockscreen";
	}

	@Override
	public boolean getStatus() {
		return Settings.System.getInt(getContext().getContentResolver(), "AlmasLockscreen",0)==1;
	}


	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tDL);
		
	}


	@Override
	public Drawable getIconOn() {
		return am.LS(false);
	}


	@Override
	public Drawable getIconOff() {
		return am.LS(true);
	}

}
