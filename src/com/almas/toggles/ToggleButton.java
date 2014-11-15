package com.almas.toggles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToggleButton extends LinearLayout {
	private final LayoutParams baseParam = new LayoutParams(
			50,60);
	private final LayoutParams pro = new LayoutParams(
			48,48);
	private final ImageView mIcon;
	private final TextView mToggle;
	public ToggleButton(Context context) {
		super(context);
	  this.setPadding(4, 0, 4, 0);
	  this.setLayoutParams(baseParam);
	  this.mIcon = new ImageView(context);
	  this.mToggle = new TextView(context);
	  this.setOrientation(LinearLayout.VERTICAL);
	  this.mToggle.setTextSize(10);
	  this.mToggle.setGravity(Gravity.CENTER_HORIZONTAL);
	  this.addView(mIcon);
	  this.addView(mToggle);
	  this.mToggle.setTextColor(Color.WHITE);
	  
	}
	public void setLabel(String name) {
		this.mToggle.setText(name);
	}
	public void setIcon( int res) {
		 this.mIcon.setImageResource(res);
	}
	public void setIconUri(Uri uri) {
		this.mIcon.setImageURI(uri);
	}
	public void setIconLevel(int u) {
		this.mIcon.setImageLevel(u);
	}
	public void setIconDrawable(Drawable i) {
		 this.mIcon.setImageDrawable(i);
	}
	public void dothat () {
		this.mIcon.setLayoutParams(pro);
	}

}
