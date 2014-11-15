package com.almas.widget;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ExtendedToggle extends LinearLayout {
	private ListView lv;
	private String[] Name = new String[] {"Profile","Wifi","Bt","Data","Gps","AutoRoation","Setting","Battery","Airplane","Sound","Sleep","Previous","PlayPause","Next",
			"Lockscreen","Screenshot","FlashLight","ScreenTimeout","Brightness","Sync","Eatter","ClearRam","AlmasConroller"};
	public ExtendedToggle(final Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		lv = new ListView(context);
		ExtendedToggleAdapter adapter = new ExtendedToggleAdapter(context, Name);
		lv.setAdapter(adapter);
		addView(lv);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int a = Settings.System.getInt(context.getContentResolver(), Name[arg2],0);
				if (a == 0 ) {
					Settings.System.putInt(context.getContentResolver(), Name[arg2], 1);
				}
				else {
					Settings.System.putInt(context.getContentResolver(), Name[arg2], 0);
				}
				Intent i =  new Intent();
				i.setAction("com.almas.UPDATE");
				context.sendBroadcast(i);
				
				Intent i1 =  new Intent();
				i1.setAction("com.almas.EXTANDING");
				context.sendBroadcast(i1);
			}
		});

	  
	}
}
