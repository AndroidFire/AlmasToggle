package com.almas.toggles;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.provider.Settings;

public class FlashLight extends TogglePower {
	
	boolean mFlash;
	public FlashLight(Context context) {
		super(context);
		PackageManager pm = context.getPackageManager();

		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
			mFlash = false;
		}
		else if (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
		{
			mFlash = true;
		}
	}

	@Override
	public void onToggleClick() {
		int m = 0;
	  if (mFlash == true )  {
		  if (m == 0 ) {
			  
		  
		  Settings.System.putInt(getContext().getContentResolver(), "AlmasLight", 1);
		  Camera camera = Camera.open();
  		Parameters p = camera.getParameters();
  		p.setFlashMode(Parameters.FLASH_MODE_OFF);
  		camera.setParameters(p);
  		camera.startPreview();
		  m++;
		  }
		  else if (m == 1) {
			  Settings.System.putInt(getContext().getContentResolver(), "AlmasLight", 0);
			  Camera camera = Camera.open();
	  		Parameters p = camera.getParameters();
	  		p.setFlashMode(Parameters.FLASH_MODE_OFF);
	  		camera.setParameters(p);
	  		camera.stopPreview();
			  m--;
		  }
		  
	  }
		
	}

	@Override
	public void onToggleLongClick() {
		
	}

	@Override
	public String getLabel() {
		return "Flashlight";
	}


	@Override
	public boolean getStatus() {
		int g = Settings.System.getInt(getContext().getContentResolver(), "AlmasLight",0);
		if (g == 0 )
		return false;
		else 
		return true;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tFl);
	}

	@Override
	public Drawable getIconOn() {
		return am.Flash(true);
	}

	@Override
	public Drawable getIconOff() {
		return am.Flash(false);
	}

}
