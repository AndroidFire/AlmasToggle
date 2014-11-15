package com.almas.window;

import com.almas.toggles.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class EatterWindow extends Activity {
	ImageView Ate;
	int And;
	@Override
	protected void onCreate(Bundle ofWindow){
		super.onCreate(ofWindow);
		setContentView(R.layout.eatter);
		Ate = (ImageView)findViewById(R.id.ate);
		And = Build.VERSION.SDK_INT;
		
		if (And == 9 || And == 10 ) {
			Ate.setImageResource(R.drawable.dessert_gingerbread);
		}
		else if (And == 11 ) {
			Ate.setImageResource(R.drawable.dessert_honeycomb);
		}
		else if (And == 14 || And == 15) {
			Ate.setImageResource(R.drawable.dessert_ics);
		}
		else if (And == 16 || And == 17 || And == 18) {
			Ate.setImageResource(R.drawable.dessert_jellybean);
		}
		else if (And == 19 ) {
			Ate.setImageResource(R.drawable.dessert_kitkat);
		}
		else if (And == 20 ) {
			// for Lolipop
		}
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
    public int getWidth() {
	DisplayMetrics di = getBaseContext().getResources().getDisplayMetrics();
	int w = di.widthPixels-20;
	return w;
}
    public int getHeight() {
	DisplayMetrics di = getBaseContext().getResources().getDisplayMetrics();
	int h = di.heightPixels-150;
	return h;
}
}
