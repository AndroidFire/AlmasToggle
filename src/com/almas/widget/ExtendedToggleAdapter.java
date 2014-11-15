package com.almas.widget;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.almas.toggles.R;

public class ExtendedToggleAdapter extends ArrayAdapter<String> {
	private final Context ctx;
	private final String[] values;

	 public ExtendedToggleAdapter(Context context, String[] values) {
		    super(context, R.layout.extended_toggle_adapter, values);
		this.ctx = context;
		this.values = values;
	 }
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		 LayoutInflater inflater = (LayoutInflater) ctx
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View rowView = inflater.inflate(R.layout.extended_toggle_adapter, parent, false);
		 TextView ToggleName = (TextView) rowView.findViewById(R.id.toggle_name);
		 final ImageView Toggle_Status = (ImageView) rowView.findViewById(R.id.toggle_status);
		 ToggleName.setText(values[position]);
			final int b = Settings.System.getInt(ctx.getContentResolver(), values[position],0);
			final Handler h = new Handler();
		       h.post(new Runnable() {

				@Override
				public void run() {
					if (b == 0 ) {
						 Toggle_Status.setImageResource(R.drawable.toggle_on);
					 }
					 else {
						 Toggle_Status.setImageResource(R.drawable.toggle_off);
					 }
						
					 h.postDelayed(this, 1000);
				}
		    	   
		       });
			
		return rowView;
		 
	 }
}
