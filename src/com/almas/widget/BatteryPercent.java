package com.almas.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 * @author Almas
 * To Get Battery Percent
 *
 */
public class BatteryPercent extends TextView {

	public BatteryPercent(Context context, AttributeSet attrs) {
		super(context, attrs);
		 BroadcastReceiver Receiver = new BroadcastReceiver() {

				@Override
				public void onReceive(Context arg0, Intent arg1) {
					int Percent = arg1.getIntExtra("level", 0);
					setText(Percent+" %");
				}
	};
	 context.registerReceiver(Receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
}

}
