package com.almas.toggles;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;

public class WIFI extends TogglePower {
	WifiManager wifi;
	public WIFI(Context context) {
		super(context);
	  wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		
	}
	@Override
	public void onToggleClick() {
		wifi.setWifiEnabled(getStatus()?false:true);
	}
	@Override
	public String getLabel() {
		return "WIFI";
	}
	@Override
	public boolean getStatus() {
		return (wifi.isWifiEnabled());
		
	}

	@Override
	public void onToggleLongClick() {
	      Intent intent = new Intent("android.settings.WIFI_SETTINGS");
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
		tg.observe(getContext(), getRootView(), tgwifi);
	}
	@Override
	public Drawable getIconOn() {
		return am.WIFI(true);
	}
	@Override
	public Drawable getIconOff() {
		return am.WIFI(false);
	}
}
