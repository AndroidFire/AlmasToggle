package com.almas.toggles;

import android.content.Context;
import android.provider.Settings;
import android.view.View;

public class TogglesObserver {
		     

	        void observe(Context context,View v,String tgName) {
	         int j = Settings.System.getInt(context.getContentResolver(), tgName, 0);
	          if (j == 1 ) {
	        	  v.setVisibility(View.GONE);
	          }
	          else if (j == 0) {
	        	  v.setVisibility(View.VISIBLE);
	          }
	        }
	    
}
