package com.almas.toggles;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;

@SuppressWarnings("deprecation")
public class GPS extends TogglePower {

	public GPS(Context context) {
		super(context);
		
	}

	@Override
	public void onToggleClick() {
		 ContentResolver resolver = getContext().getContentResolver();
			String provider = Settings.Secure.getString(resolver, Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		 if (getStatus()?provider.contains("gps"):!provider.contains("gps")) {
				final Intent poke = new Intent();
				poke.setClassName("com.android.settings",
				"com.android.settings.widget.SettingsAppWidgetProvider");
				poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
				poke.setData(Uri.parse("3"));
				getContext().sendBroadcast(poke);
			}
		
	}

	@Override
	public void onToggleLongClick() {
		 Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
	        intent.addCategory(Intent.CATEGORY_DEFAULT);
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "GPS";
	}


	@Override
	public boolean getStatus() {
		ContentResolver resolver = getContext().getContentResolver();
		return Settings.Secure.isLocationProviderEnabled(resolver,
                LocationManager.GPS_PROVIDER);
	}
	@Override
	public void onUpdate() {

	}

	@Override
	public void onTogglerObserver() {
		
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tGps);
	}

	@Override
	public Drawable getIconOn() {
		return am.GPS(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.GPS(false);
	}


}
