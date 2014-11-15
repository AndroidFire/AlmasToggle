package com.almas.toggles;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class ToggleGridView extends GridView {
	String Default_Cluster = Helper.def_clus;
	String[] Def_Clus;
	String My_Cluster;
	private boolean isGridView;
	int mColumn;
	ArrayList<TogglePower> toggles = new ArrayList<TogglePower>();
	public ToggleGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		context.registerReceiver(RemoveToggle, new IntentFilter("com.almas.UPDATE"));
		context.registerReceiver(Column, new IntentFilter("com.almas.UPDATE_GRIDVIEW"));
		if (My_Cluster == null ) {
			My_Cluster = Default_Cluster;
		}
		else {
			Default_Cluster = My_Cluster;
		}
		
		isGridView = Settings.System.getInt(context.getContentResolver(),"AlmasTogglePolicy", 0 ) == 1;
		boolean isNeutral = Settings.System.getInt(context.getContentResolver(), "isToggleisNeutral" ,0 ) ==1 ;
		mColumn = Settings.System.getInt(context.getContentResolver(), "AlmasColumn", 4);
		
		if (mColumn == 0 )  {
			setNumColumns(4);
		}
		else {
			setNumColumns(mColumn);
		}
		
		if (isNeutral) {
			setVisibility(View.GONE);
		}
		GridViewAdapter mAdapter = new GridViewAdapter(context, toggles);
		setAdapter(mAdapter);
		
	       Def_Clus = Default_Cluster.split(" ");
			for (int i = 0 ; i < Def_Clus.length ; i++ ) {
				addToggle(Def_Clus[i]);
			}

		if (isGridView) {
		setVisibility(View.VISIBLE);
		}
		else {
			setVisibility(View.GONE);
		}
		
	}
	BroadcastReceiver RemoveToggle = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent i) {
			GridViewAdapter mAdapter = new GridViewAdapter(context, toggles);
			setAdapter(mAdapter);
			isGridView = Settings.System.getInt(context.getContentResolver(),"AlmasTogglePolicy", 0 ) == 1;
			invalidate();
			if (isGridView) {
				setVisibility(View.VISIBLE);
				}
				else {
					setVisibility(View.GONE);
				}
		}
	};
	BroadcastReceiver Column = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent i) {
			String s = i.getStringExtra("Column");
			int si = (Integer.parseInt(s));
			Settings.System.putInt(context.getContentResolver(), "AlmasColumn", si);
			setNumColumns(si);
		}
	};
	
	
	private void addToggle(final String s) {
				
				int b = Settings.System.getInt(getContext().getContentResolver(), s ,0);
				if(b == 0) {
					if (s.equalsIgnoreCase("wifi")) {
						WIFI w = new WIFI(getContext());
						toggles.add(w);
					}
					else if (s.equalsIgnoreCase("bt")) {
						BT by = new BT(getContext());
						toggles.add(by);
					}
					else if (s.equalsIgnoreCase("gps")) {
						GPS gps = new GPS(getContext());
						toggles.add(gps);
					}
					else if (s.equalsIgnoreCase("data")) {
						DATA d = new DATA(getContext());
						toggles.add(d);
					}
					else if (s.equalsIgnoreCase("sound")) {
						Sound so = new Sound(getContext());
						toggles.add(so);
					}
					else if (s.equalsIgnoreCase("autoroation")) {
						Rotage r = new Rotage(getContext());
						toggles.add(r);
					}
					else if (s.equalsIgnoreCase("sleep")) {
						Sleep sp = new Sleep(getContext());
						toggles.add(sp);
					}
					else if (s.equalsIgnoreCase("airplane")) {
						Airplane air = new Airplane(getContext());
						toggles.add(air);
					}
					else if (s.equalsIgnoreCase("profile")) {
						Profile pro = new Profile(getContext());
						toggles.add(pro);
					}
					else if (s.equalsIgnoreCase("previous")) {
						Prev prev = new Prev(getContext());
						toggles.add(prev);
					}
					else if (s.equalsIgnoreCase("playpause")) {
						PlayPause play = new PlayPause(getContext());
						toggles.add(play);
					}
					else if (s.equalsIgnoreCase("next")) {
						Next next = new Next(getContext());
						toggles.add(next);
					}
					else if (s.equalsIgnoreCase("settings")) {
						com.almas.toggles.Settings set = new com.almas.toggles.Settings(getContext());
						toggles.add(set);
					}
					else if (s.equalsIgnoreCase("clearram")) {
						ClearRam cr = new ClearRam(getContext());
						toggles.add(cr);
					}
					else if (s.equalsIgnoreCase("brightness")) {
						Brightness by = new Brightness(getContext());
						toggles.add(by);
					}
					else if (s.equalsIgnoreCase("eatter")) {
						Eatter ate = new Eatter(getContext()); 
						toggles.add(ate);
					}
					else if (s.equalsIgnoreCase("battery")) {
						Battery bat = new Battery(getContext());
						toggles.add(bat);
					}
					else if (s.equalsIgnoreCase("sync")) {
						Sync sy = new Sync(getContext());
						toggles.add(sy);
					}
					else if (s.equalsIgnoreCase("screentimeout")) {
						ScreenTimeout st =new ScreenTimeout(getContext());
						toggles.add(st);
					}
					else if (s.equalsIgnoreCase("screenshot")) {
						Screenshot ss = new Screenshot(getContext());
						toggles.add(ss);
					}
					else if (s.equalsIgnoreCase("flashlight")) {
						FlashLight fl = new FlashLight(getContext());
						toggles.add(fl);
					}
					else if (s.equalsIgnoreCase("reboot")) {
						Reboot rb = new Reboot(getContext());
						toggles.add(rb);
					}
					else if (s.equalsIgnoreCase("lockscreen")) {
						Lockscreen ls = new Lockscreen(getContext());
						toggles.add(ls);
					}
					else if (s.equalsIgnoreCase("almasconroller")) {
						Conroller ac = new Conroller(getContext());
						toggles.add(ac);
					}
				}
	}
	

}
