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
	String Default_Cluster;
	String[] Def_Clus;
	String My_Cluster;
	private boolean isGridView;
	int mColumn;
	GridViewAdapter mAdapter;
	ArrayList<TogglePower> toggles = new ArrayList<TogglePower>();
	public ToggleGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		context.registerReceiver(RemoveToggle, new IntentFilter("com.almas.UPDATE"));
		context.registerReceiver(Column, new IntentFilter("com.almas.UPDATE_GRIDVIEW"));
		context.registerReceiver(Policy, new IntentFilter("com.almas._POLICY_UPDATE"));
		My_Cluster = Settings.System.getString(context.getContentResolver(), "AlmasCluster");
		
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
		 mAdapter = new GridViewAdapter(context, toggles);
		setAdapter(mAdapter);
		
	       Def_Clus = Default_Cluster.split(" ");
			for (int i = 0 ; i < Def_Clus.length ; i++ ) {
				addToggle(Def_Clus[i], toggles);
			}

		if (isGridView) {
		setVisibility(View.VISIBLE);
		}
		else {
			setVisibility(View.GONE);
		}
		
	}
	
	BroadcastReceiver Policy = new BroadcastReceiver() {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			isGridView = Settings.System.getInt(arg0.getContentResolver(),"AlmasTogglePolicy", 0 ) == 1;
			if (isGridView) {
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
			
			 String[] ss;
			String My_Clusterr = Settings.System.getString(context.getContentResolver(), "AlmasCluster");
			 ArrayList<TogglePower> toggle= new ArrayList<TogglePower>();
			 toggles.clear();


			 ss = My_Clusterr.split(" ");
			 GridViewAdapter mAdapterr = new GridViewAdapter(context, toggle);
			 setAdapter(mAdapterr);
			 for (int ib = 0 ; ib < ss.length ; ib++ ) {
					addToggle(ss[ib], toggle);
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
	
	
	private void addToggle(final String s,ArrayList<TogglePower> a) {
				
				int b = Settings.System.getInt(getContext().getContentResolver(), s ,0);
				if(b == 0) {
					if (s.equalsIgnoreCase("wifi")) {
						WIFI w = new WIFI(getContext());
						a.add(w);
					}
					else if (s.equalsIgnoreCase("bt")) {
						BT by = new BT(getContext());
						a.add(by);
					}
					else if (s.equalsIgnoreCase("gps")) {
						GPS gps = new GPS(getContext());
						a.add(gps);
					}
					else if (s.equalsIgnoreCase("data")) {
						DATA d = new DATA(getContext());
						a.add(d);
					}
					else if (s.equalsIgnoreCase("sound")) {
						Sound so = new Sound(getContext());
						a.add(so);
					}
					else if (s.equalsIgnoreCase("AutoRotate")) {
						Rotage r = new Rotage(getContext());
						a.add(r);
					}
					else if (s.equalsIgnoreCase("sleep")) {
						Sleep sp = new Sleep(getContext());
						a.add(sp);
					}
					else if (s.equalsIgnoreCase("airplane")) {
						Airplane air = new Airplane(getContext());
						a.add(air);
					}
					else if (s.equalsIgnoreCase("profile")) {
						Profile pro = new Profile(getContext());
						a.add(pro);
					}
					else if (s.equalsIgnoreCase("previous")) {
						Prev prev = new Prev(getContext());
						a.add(prev);
					}
					else if (s.equalsIgnoreCase("playpause")) {
						PlayPause play = new PlayPause(getContext());
						a.add(play);
					}
					else if (s.equalsIgnoreCase("next")) {
						Next next = new Next(getContext());
						a.add(next);
					}
					else if (s.equalsIgnoreCase("settings")) {
						com.almas.toggles.Settings set = new com.almas.toggles.Settings(getContext());
						a.add(set);
					}
					else if (s.equalsIgnoreCase("clearram")) {
						ClearRam cr = new ClearRam(getContext());
						a.add(cr);
					}
					else if (s.equalsIgnoreCase("brightness")) {
						Brightness by = new Brightness(getContext());
						a.add(by);
					}
					else if (s.equalsIgnoreCase("eatter")) {
						Eatter ate = new Eatter(getContext()); 
						a.add(ate);
					}
					else if (s.equalsIgnoreCase("battery")) {
						Battery bat = new Battery(getContext());
						a.add(bat);
					}
					else if (s.equalsIgnoreCase("sync")) {
						Sync sy = new Sync(getContext());
						a.add(sy);
					}
					else if (s.equalsIgnoreCase("screentimeout")) {
						ScreenTimeout st =new ScreenTimeout(getContext());
						a.add(st);
					}
					else if (s.equalsIgnoreCase("screenshot")) {
						Screenshot ss = new Screenshot(getContext());
						a.add(ss);
					}
					else if (s.equalsIgnoreCase("flashlight")) {
						FlashLight fl = new FlashLight(getContext());
						a.add(fl);
					}
					else if (s.equalsIgnoreCase("wifiapp")) {
						WifiApp rb = new WifiApp(getContext());
						a.add(rb);
					}
					else if (s.equalsIgnoreCase("lockscreen")) {
						Lockscreen ls = new Lockscreen(getContext());
						a.add(ls);
					}
					else if (s.equalsIgnoreCase("almasconroller")) {
						Conroller ac = new Conroller(getContext());
						a.add(ac);
					}
				}
	}
	

}
