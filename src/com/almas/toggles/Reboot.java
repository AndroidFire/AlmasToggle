package com.almas.toggles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;

public class Reboot extends TogglePower {
	PowerManager pm ;
	String items[] = {"Reboot", "Recovery"};
	AlertDialog.Builder ab;
	public Reboot(Context context) {
		super(context);
		 pm = (PowerManager) context
				.getSystemService(Context.POWER_SERVICE);
		  
			 ab=new AlertDialog.Builder(getContext());
			ab.setTitle("Reboot");
			ab.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface d, int choice) {
					if(choice == 0)
						pm.reboot("now");
					else
						pm.reboot("recovery");
				}
			});
	}

	@Override
	public void onToggleClick() {
	ab.show();
		
	}

	@Override
	public void onToggleLongClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel() {
		return "Reboot";
	}



	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tRe);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.Reboot();
	}

	@Override
	public Drawable getIconOff() {
		return am.Reboot();
	}

}
