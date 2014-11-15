package com.almas.toggles;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class BT extends TogglePower {

	 BluetoothAdapter BTAdapter;

	public BT(Context context) {
		super(context);
		BTAdapter = BluetoothAdapter.getDefaultAdapter();
		
	}

	@Override
	public void onToggleClick() {
		if (getStatus()==true) {
			BTAdapter.disable();
		}
		else {
			BTAdapter.enable();
		}
		
	}

	@Override
	public String getLabel() {
		return "BT";
	}

	@Override
	public boolean getStatus() {
		return BTAdapter.isEnabled();
	}

	@Override
	public void onToggleLongClick() {
		   Intent intent = new Intent("android.settings.BLUETOOTH_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
		
	}
	@Override
	public void onUpdate() {
	
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tgBT);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.BT(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.BT(false);
	}

}
