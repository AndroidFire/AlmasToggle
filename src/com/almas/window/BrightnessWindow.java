package com.almas.window;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;

import com.almas.toggles.R;

public class BrightnessWindow extends Activity {
	SeekBar Bright;
	float b;
    int mCur = 0;
    Window window ;
    ContentResolver cResolver;
    int Progress;
	@Override
	protected void onCreate(Bundle ofWindow){
		super.onCreate(ofWindow);
		setContentView(R.layout.bright_slider);
		Bright = (SeekBar)findViewById(R.id.brightness);
		Bright.setMax(255);
		
		try {
			 b = android.provider.Settings.System.getInt(getContentResolver(), "screen_brightness");
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
		}
		mCur = (int) b;
		Bright.setProgress(mCur);
		 window = getWindow();
		 cResolver = getContentResolver();
		Bright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				Settings.System.putInt(cResolver, "screen_brightness", Progress);
				LayoutParams layoutpars = window.getAttributes();
                layoutpars.screenBrightness = Progress / (float) 255;
                window.setAttributes(layoutpars);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				Progress = arg1;
				 if(arg1<=20)
	                {
					 Progress = 20;
	                }
	                else 
	                {
	                	Progress = arg1;
	                }
			}
		});

	
	}
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 60;
	}
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
	
		  View view = getWindow().getDecorView();  
		 view.setBackgroundResource(R.drawable.dialog_full_holo_dark);
          WindowManager.LayoutParams lp = (WindowManager.LayoutParams) view.getLayoutParams();  

         lp.gravity = Gravity.CENTER;  
         lp.width = getWidth();
         lp.height = getHeight();
 		setTheme(android.R.style.Theme_Translucent_NoTitleBar);

         getWindowManager().updateViewLayout(view, lp);
		
	}	
	
	



}
