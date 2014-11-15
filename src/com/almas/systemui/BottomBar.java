package com.almas.systemui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.almas.widget.AlmasMaster;

public class BottomBar extends ImageView {
	AlmasMaster am;
	public BottomBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		am = new AlmasMaster(context);
		setImageDrawable(am.Sys_Close());
		setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Log.d("StatusBarClose", "is On");
				
			}
		});
	}


}
