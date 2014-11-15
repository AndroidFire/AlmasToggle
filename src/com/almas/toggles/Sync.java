package com.almas.toggles;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.graphics.drawable.Drawable;

public class Sync extends TogglePower {

	public Sync(Context context) {
		super(context);
		 ContentResolver.addStatusChangeListener(1, this.mSyncObserver);
	}

	@Override
	public void onToggleClick() {
		ContentResolver.setMasterSyncAutomatically(getStatus()?false:true);
		
	}

	@Override
	public void onToggleLongClick() {
		  Intent intent = new Intent("android.settings.SYNC_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
	}

	@Override
	public String getLabel() {
		return "Sync";
	}


	@Override
	public boolean getStatus() {
		return ContentResolver.getMasterSyncAutomatically();
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tSy);
		
	}

    SyncStatusObserver mSyncObserver = new SyncStatusObserver() {
            public void onStatusChanged(int which) {
               
                getIconOn();
                getIconOff();
            }
        };

	@Override
	public Drawable getIconOn() {
		return am.Sync(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Sync(false);
	}

}
