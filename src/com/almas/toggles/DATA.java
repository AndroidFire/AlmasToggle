package com.almas.toggles;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class DATA extends TogglePower {
	DataLiestner mDL;
	private TelephonyManager tman;

	public DATA(Context context) {
		super(context);
		
		 getData();
		 
	}

	private void getData() {
		mDL = new DataLiestner();
		tman = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
		tman.listen(mDL, PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
		
	}

	@Override
	public void onToggleClick() {
		setMobileDataEnabled(getContext(), getStatus()?false:true);

	}

	@Override
	public String getLabel() {
		return "Data";
	}

	@Override
	public boolean getStatus() {
		return Settings.System.getInt(getContext().getContentResolver(), "DATA",0)==1;
		
	}
	
		@Override
		public void onToggleLongClick() {
	        Intent intent = new Intent(Intent.ACTION_MAIN);
	        intent.setClassName("com.android.phone", "com.android.phone.Settings");
	        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        getContext().startActivity(intent);
			
		}

	public class DataLiestner extends PhoneStateListener {

			@Override
			public void onDataConnectionStateChanged(int arg0) {
				super.onDataConnectionStateChanged(arg0);
				
				if (arg0 == 0 ) {
				 Settings.System.putInt(getContext().getContentResolver(), "DATA",0 );
				}
				else {
					 Settings.System.putInt(getContext().getContentResolver(), "DATA",1 );
				}
			}

		}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setMobileDataEnabled(Context context, boolean enabled) {
		 try {
			 
		   //create instance of connectivity manager and get system connectivity service
		   final ConnectivityManager conman = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
				   final Class conmanClass  = Class.forName(conman.getClass().getName());
		  		   final Field iConnectivityManagerField= conmanClass.getDeclaredField("mService");
		  	   iConnectivityManagerField.setAccessible(true);
		     final Object iConnectivityManager = iConnectivityManagerField.get(conman);
		  	   final Class iConnectivityManagerClass=  Class.forName(iConnectivityManager.getClass().getName());
		  	   final Method setMobileDataEnabledMethod= iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled",Boolean.TYPE);
		     setMobileDataEnabledMethod.setAccessible(true);
		      setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
		  } catch (Exception e){
		  }
		
	}


	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tData);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Data(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Data(false);
	}

}
