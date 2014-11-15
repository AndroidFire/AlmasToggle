package com.almas.toggles;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;

import com.almas.widget.WifiHotspotAdapter;

public class WifiApp extends TogglePower {
	WifiHotspotAdapter AlmasManager;
	WifiManager wifiManager;
	public WifiApp(Context context) {
		super(context);
		 wifiManager = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
		AlmasManager = new WifiHotspotAdapter(wifiManager);
	}

	@Override
	public void onToggleClick() {
		AlmasManager.turn(getContext(), getStatus()?false:true);
		
	}

	@Override
	public void onToggleLongClick() {
		  Intent intent = new Intent(Intent.ACTION_MAIN);
	        intent.setClassName("com.android.settings", "com.android.settings.TetherSettings");
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "WIFI Hotspot";
	}


	@Override
	public boolean getStatus() {
		return AlmasManager.isWifiApEnabled();
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), "WifiApp");
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Hotspot(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Hotspot(false);
	}
}
