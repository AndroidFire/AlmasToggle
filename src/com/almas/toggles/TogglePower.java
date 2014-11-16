package com.almas.toggles;


import java.lang.reflect.Method;

import com.almas.widget.AlmasMaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;
public abstract class TogglePower extends LinearLayout {
	@SuppressWarnings("rawtypes")
	private final Class[] Toggle = {WIFI.class};
	private final ToggleButton mTG;
	protected String label;
	AlmasMaster am;
	 int icon;
	 SettingsObserver mSettingsObserver;
	 String tgwifi = "Wifi";
	 String tgBT = "Bt";
	 String tData = "Data";
	 String tGps = "Gps";
	 String tSo = "Sound";
	 String tgRo = "AutoRoation";
	 String tAir = "Airplane";
	 String tSleep = "Sleep";
	 String tSet = "Settings";
	 String tPrev = "Previous";
	 String tNext = "Next";
	 String tPP = "PlayPause";
	 String tDL = "Lockscreen";
	 String tRe = "Reboot";
	 String tSc = "Screenshot";
	 String tFl = "FlashLight";
	 String tST = "ScreenTimeout";
	 String tPro = "Profile";
	 String tBr = "Brightness";
	 String tSy = "Sync";
	 String tBat = "Battery";
	 String tEat = "Eatter";
	 String tCr = "ClearRam";
	 String tWA = "";
	 private int level_icon;
	 private Drawable mDrawable;
	 int hideonchange;
	 String tag = "AlmasToggle";
	public TogglePower(final Context context) {
		super(context);
		mTG = new ToggleButton(context);
		mSettingsObserver = new SettingsObserver();
		hideonchange = android.provider.Settings.System.getInt(context.getContentResolver(), "AlmasToggleHC",0);
		context.registerReceiver(ToggleSmiler, new IntentFilter("com.almas.EXTANDING"));
		context.registerReceiver(HideonChange, new IntentFilter("com.almas.HIDE_ON_CHANGE"));
		int j = Toggle.length;
		am = new AlmasMaster(context);
		for (int i = 0; i < j ; i++) {
			mSettingsObserver.observe(getRootView());
			onTogglerObserver();
				setPadding(0, 12, 0, 0);
			addView(mTG);
			final Handler h = new Handler();
		       h.post(new Runnable() {
		      @Override
		      public void run() {
		    	  mTG.setLabel(getLabel());
		    	  mTG.setIconLevel(getLevel_icon());
		    	 
		    	  if (getIconOff() == null) {
		    		  String p = Settings.System.getString(getContext().getContentResolver(), "AlmasPhoto" );
		    		  if (p == null ) {
		    			  mTG.setIcon(R.drawable.avatar_default_1);
		    		  }
		    		  else {
		    			  mTG.setIconUri(Uri.parse(p));
		    			  mTG.dothat();
		    			  setPadding(0, 0, 0, 0);
		    		  }
		    	  }
					if (getStatus() == true ) {
						if (getIconOn() != null) {
							
						
						mTG.setIconDrawable(getIconOn());
						}
						}
						else if (getStatus() == false ) {
							if (getIconOff() != null) {
						mTG.setIconDrawable(getIconOff());
							}
						}
					onUpdate();

		          h.postDelayed(this, 1000);
		      }
		           }); 
			mTG.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					onToggleClick();
					 if (hideonchange == 1 ) {
			    		  try{ 
					    	   Object service  = context.getSystemService("statusbar");
					    	   Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
					    	   Method collapse = statusbarManager.getMethod("collapse");
					    	   collapse.invoke(service);
					    	 }
					    	 catch(Exception ex){           

					    	 }  
			    	  }
			    	  else {
			    		  
			    	  }
				}
			});
		}
		mTG.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				onToggleLongClick();
				
				 if (hideonchange == 1 ) {
		    		  try{ 
				    	   Object service  = context.getSystemService("statusbar");
				    	   Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
				    	   Method collapse = statusbarManager.getMethod("collapse");
				    	   collapse.invoke(service);
				    	 }
				    	 catch(Exception ex){           

				    	 }  
		    	  }
		    	  else {
		    		  
		    	  }
				return true;
			}
		});
	}



	BroadcastReceiver ToggleSmiler = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent i) {
				onTogglerObserver();
				 
		}
	};
	BroadcastReceiver HideonChange = new BroadcastReceiver() {

		@Override
		public void onReceive(final Context context, Intent i) {
			mTG.setOnLongClickListener(new View.OnLongClickListener() {
				int  b  = android.provider.Settings.System.getInt(context.getContentResolver(), "AlmasToggleHC",0);
				@Override
				public boolean onLongClick(View arg0) {
					onToggleLongClick();
					hideonchange = b;
					 if (hideonchange == 1 ) {
			    		  try{ 
					    	   Object service  = context.getSystemService("statusbar");
					    	   Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
					    	   Method collapse = statusbarManager.getMethod("collapse");
					    	   collapse.invoke(service);
					    	 }
					    	 catch(Exception ex){           

					    	 }  
			    	  }
			    	  else {
			    		  
			    	  }
					
				
					return true;
				}
			});
				mTG.setOnClickListener(new View.OnClickListener() {
					int  b  = android.provider.Settings.System.getInt(context.getContentResolver(), "AlmasToggleHC",0);
					@Override
					public void onClick(View arg0) {
						onToggleClick();
						hideonchange = b;
						 if (hideonchange == 1 ) {
				    		  try{ 
						    	   Object service  = context.getSystemService("statusbar");
						    	   Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
						    	   Method collapse = statusbarManager.getMethod("collapse");
						    	   collapse.invoke(service);
						    	 }
						    	 catch(Exception ex){           

						    	 }  
				    	  }
				    	  else {
				    		  
				    	  }
						
					}
				});
				
		}
	};
	public abstract void onToggleClick();
	public abstract void onToggleLongClick();
	public abstract String getLabel();
	public String setLabel(String name) {
		return name = label;
	}
	public abstract Drawable getIconOn();
	public abstract Drawable getIconOff();
	public abstract boolean getStatus();
	public abstract void onTogglerObserver();


	public void onUpdate() {

	}
	public int getLevel_icon() {
		return level_icon;
	}
	public void setLevel_icon(int level_icon) {
		this.level_icon = level_icon;
	}
	public Drawable getIconDrawable() {
		return mDrawable;
	}
	public void setIconDrawable(Drawable mDrawable) {
		this.mDrawable = mDrawable;
	}

	class SettingsObserver  {
     

        void observe(View v) {
         int j = Settings.System.getInt(getContext().getContentResolver(), "AlmasToggle", 0);
          if (j == 1 ) {
        	  v.setVisibility(View.GONE);
          }
          else if (j == 0 ) {

        	  v.setVisibility(View.VISIBLE);
          }
          
          
        }
    }
    
}
