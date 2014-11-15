package com.almas.toggles;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;

public class Conroller extends TogglePower {

	public Conroller(Context context) {
		super(context);
	}

	@Override
	public void onToggleClick() {
	
		Intent i = new Intent();
		i.setClassName("com.almas.toggles", "com.almas.widget.Settings");
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(i);
        
	}

	@Override
	public void onToggleLongClick() {
		
	}

	@Override
	public String getLabel() {
		return "Controller";
	}

	@Override
	public boolean getStatus() {
		return false;
	}
	
	  
	  protected int getCurrentAPIVersion()
	  {
	    return Build.VERSION.SDK_INT;
	  }

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), "AlmasConroller");
	
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Controller();
	}

	@Override
	public Drawable getIconOff() {
		return am.Controller();
	}
}
