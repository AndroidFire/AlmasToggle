package com.almas.toggles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class ToggleHorizontalView extends HorizontalScrollView {
	
	LinearLayout My_Layout;
	String Default_Cluster = Helper.def_clus;
	String[] Def_Clus;
	String My_Cluster;
    int isHorizonView;
	public ToggleHorizontalView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		
		context.registerReceiver(RemoveToggle, new IntentFilter("com.almas.UPDATE"));
		context.registerReceiver(Policy, new IntentFilter("com.almas._POLICY_UPDATE"));
		My_Cluster = Settings.System.getString(context.getContentResolver(), "AlmasCluster");
		My_Layout = new LinearLayout(context);
		addView(My_Layout);
		 if (My_Cluster == null) {
			 Default_Cluster = Helper.def_clus;
		 }
		 else if (My_Cluster == "" ){
			 Default_Cluster = Helper.def_clus;
		 }
		 else if (My_Cluster != null ) {
			 Default_Cluster = My_Cluster;
		 }
		 else if (My_Cluster != "") {
			 Default_Cluster = My_Cluster; 
		 }
		
		isHorizonView = Settings.System.getInt(context.getContentResolver(),"AlmasTogglePolicy", 0);
		boolean isNeutral = Settings.System.getInt(context.getContentResolver(), "isToggleisNeutral" ,0 ) ==1 ;
		
		if (isNeutral) {
			setVisibility(View.GONE);
		}
	       Def_Clus = Default_Cluster.split(" ");
			for (int i = 0 ; i < Def_Clus.length ; i++ ) {
				addToggle(Def_Clus[i], My_Layout);
			}
			if (isHorizonView == 0) {
				setVisibility(View.VISIBLE);
				}
				else {
					setVisibility(View.GONE);
				}
				
			

	}
	BroadcastReceiver Policy = new BroadcastReceiver() {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			isHorizonView = Settings.System.getInt(arg0.getContentResolver(),"AlmasTogglePolicy", 0);
			if (isHorizonView == 0) {
				setVisibility(View.VISIBLE);
				}
				else {
					setVisibility(View.GONE);
				}
			
		}

		
		};
	BroadcastReceiver RemoveToggle = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent i) {
			removeAllViewsInLayout();
			LinearLayout My_Layoutb = new LinearLayout(context);
			addView(My_Layoutb);
			
			String My_Clusterr = Settings.System.getString(context.getContentResolver(), "AlmasCluster");
			String[] ss;
			ss = My_Clusterr.split(" ");
			for (int ib = 0 ; ib < ss.length ; ib++ ) {
				addToggle(ss[ib], My_Layoutb);
			}
			
			invalidate();
		
		  }
	};

	private void addToggle(String s,LinearLayout My_Layout) {
		int b = Settings.System.getInt(getContext().getContentResolver(), s ,0);
		if(b == 0) {
			if (s.equalsIgnoreCase("wifi")) {
				WIFI w = new WIFI(getContext());
				My_Layout.addView(w);
			}
			else if (s.equalsIgnoreCase("bt")) {
				BT by = new BT(getContext());
				My_Layout.addView(by);
			}
			else if (s.equalsIgnoreCase("gps")) {
				GPS gps = new GPS(getContext());
				My_Layout.addView(gps);
			}
			else if (s.equalsIgnoreCase("data")) {
				DATA d = new DATA(getContext());
				My_Layout.addView(d);
			}
			else if (s.equalsIgnoreCase("sound")) {
				Sound so = new Sound(getContext());
				My_Layout.addView(so);
			}
			else if (s.equalsIgnoreCase("autoroation")) {
				Rotage r = new Rotage(getContext());
				My_Layout.addView(r);
			}
			else if (s.equalsIgnoreCase("sleep")) {
				Sleep sp = new Sleep(getContext());
				My_Layout.addView(sp);
			}
			else if (s.equalsIgnoreCase("airplane")) {
				Airplane air = new Airplane(getContext());
				My_Layout.addView(air);
			}
			else if (s.equalsIgnoreCase("profile")) {
				Profile pro = new Profile(getContext());
				My_Layout.addView(pro);
			}
			else if (s.equalsIgnoreCase("previous")) {
				Prev prev = new Prev(getContext());
				My_Layout.addView(prev);
			}
			else if (s.equalsIgnoreCase("playpause")) {
				PlayPause play = new PlayPause(getContext());
				My_Layout.addView(play);
			}
			else if (s.equalsIgnoreCase("next")) {
				Next next = new Next(getContext());
				My_Layout.addView(next);
			}
			else if (s.equalsIgnoreCase("settings")) {
				com.almas.toggles.Settings set = new com.almas.toggles.Settings(getContext());
				My_Layout.addView(set);
			}
			else if (s.equalsIgnoreCase("clearram")) {
				ClearRam cr = new ClearRam(getContext());
				My_Layout.addView(cr);
			}
			else if (s.equalsIgnoreCase("brightness")) {
				Brightness by = new Brightness(getContext());
				My_Layout.addView(by);
			}
			else if (s.equalsIgnoreCase("eatter")) {
				Eatter ate = new Eatter(getContext()); 
				My_Layout.addView(ate);
			}
			else if (s.equalsIgnoreCase("battery")) {
				Battery bat = new Battery(getContext());
				My_Layout.addView(bat);
			}
			else if (s.equalsIgnoreCase("sync")) {
				Sync sy = new Sync(getContext());
				My_Layout.addView(sy);
			}
			else if (s.equalsIgnoreCase("screentimeout")) {
				ScreenTimeout st =new ScreenTimeout(getContext());
				My_Layout.addView(st);
			}
			else if (s.equalsIgnoreCase("screenshot")) {
				Screenshot ss = new Screenshot(getContext());
				My_Layout.addView(ss);
			}
			else if (s.equalsIgnoreCase("flashlight")) {
				FlashLight fl = new FlashLight(getContext());
				My_Layout.addView(fl);
			}
			else if (s.equalsIgnoreCase("wifiapp")) {
				WifiApp rb = new WifiApp(getContext());
				My_Layout.addView(rb);
			}
			else if (s.equalsIgnoreCase("lockscreen")) {
				Lockscreen ls = new Lockscreen(getContext());
				My_Layout.addView(ls);
			}
			else if (s.equalsIgnoreCase("almasconroller")) {
				Conroller ac = new Conroller(getContext());
				My_Layout.addView(ac);
			}	
		}
	}
		
}
