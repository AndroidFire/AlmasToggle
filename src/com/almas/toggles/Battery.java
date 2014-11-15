package com.almas.toggles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.provider.Settings;
import android.util.Log;

public class Battery extends TogglePower {
	int Percent;
	public Battery(Context context) {
		super(context);
		
        BroadcastReceiver Receiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context arg0, Intent arg1) {
				Percent = arg1.getIntExtra("level", 0);
				int status = arg1.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                                      status == BatteryManager.BATTERY_STATUS_FULL;
                Settings.System.putInt(arg0.getContentResolver(), "BatteryPercent",Percent);
                setLevel_icon(Percent);
                if (isCharging == true ) {
                	Settings.System.putInt(arg0.getContentResolver(), "ChargingMode", 1);
                }
                else {
                	Settings.System.putInt(arg0.getContentResolver(), "ChargingMode", 0);
                	Log.e(tag, "Not Connected to Charging");
                }
			}

        };
        context.registerReceiver(Receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}
	 
	@Override
	public void onToggleClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onToggleLongClick() {
		Intent intent = new Intent("android.intent.action.POWER_USAGE_SUMMARY");
		intent.addCategory("android.intent.category.DEFAULT");
	    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
	}

	@Override
	public String getLabel() {
		return Settings.System.getInt(getContext().getContentResolver(), "BatteryPercent", 0)+" %";
	}
	
	@Override
	public boolean getStatus() {
		int b = 	Settings.System.getInt(getContext().getContentResolver(), "ChargingMode", 0);
		if (b == 1 ) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tBat);
		
	}
	@Override
	public void onUpdate() {
		getStatus();
		getLabel();
	}

	@Override
	public Drawable getIconOn() {
		return am.Bat(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Bat(false);
	}


}
