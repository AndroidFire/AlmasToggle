package com.almas.window;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.almas.toggles.R;

public class TimeoutWindow extends Activity {
	SeekBar Timeout;
	int Current;
	int Progress = 0;
	
	@Override
	protected void onCreate(Bundle ofWindow){
		super.onCreate(ofWindow);
		setContentView(R.layout.screen_timeout);
		Timeout =  (SeekBar)findViewById(R.id.timeout);
		try {
			Current  = Settings.System.getInt(getContentResolver(),Settings.System.SCREEN_OFF_TIMEOUT);
		} catch (SettingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timeout.setMax(6);
		
		if (Current == 15000) {
			Timeout.setProgress(1);
		}
		else if (Current == 30000 ) {
			Timeout.setProgress(2);
		}
		else if (Current == 60000) {
			Timeout.setProgress(3);
		}
		else if (Current == 120000) {
			Timeout.setProgress(4);
		}
		else if (Current == 60000*10) {
			Timeout.setProgress(5);
		}
		else if (Current == 60000*30) {
			Timeout.setProgress(6);
		}
		Timeout.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				if (Progress == 1 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 15000);
				}
				else if (Progress == 2 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 30000);
				}
				else if (Progress == 3 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 60000);
				}
				else if (Progress == 4 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 120000);
				}
				else if (Progress == 5 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 60000*10);
				}
				else if (Progress == 6 ) {
					android.provider.Settings.System.putInt(getBaseContext().getContentResolver(),
 		    	            Settings.System.SCREEN_OFF_TIMEOUT, 60000*30);
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				Progress = arg1;
				
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
