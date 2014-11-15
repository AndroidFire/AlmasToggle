package com.almas.window;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.almas.toggles.R;

public class ProfileWindow extends Activity {
	ImageView MyPhoto;
	TextView MyName;
	TextView Photo_Picker;
	EditText Name_Input;
	ImageView Name_Setter;
	String OldName = "";
	String MyPhotoUri = "";
	Uri MyUri;
	@Override
	protected void onCreate(Bundle saveofBundle) {
		super.onCreate(saveofBundle);
		setContentView(R.layout.profile_set);
		MyPhoto = (ImageView)findViewById(R.id.my_photo);
		MyName = (TextView)findViewById(R.id.my_name);
		Photo_Picker = (TextView)findViewById(R.id.photo_picker);
		Name_Input = (EditText)findViewById(R.id.input_name);
		Name_Setter = (ImageView)findViewById(R.id.set_name);
		
		OldName = Settings.System.getString(getBaseContext().getContentResolver(), "AlmasName" );
		MyPhotoUri = Settings.System.getString(getBaseContext().getContentResolver(), "AlmasPhoto" );

		if (OldName == null ) {
			MyName.setText("Profile");
			Name_Input.setText("Profile");
		}
		else {
			MyName.setText(OldName);
			Name_Input.setText(OldName);
		}
		if (MyPhotoUri == null ) {
			MyPhoto.setImageResource(R.drawable.avatar_default_1);
		}
		else {
			MyPhoto.setImageURI(Uri.parse(MyPhotoUri));
		}
		Name_Setter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String getName = Name_Input.getText().toString();
				Settings.System.putString(getBaseContext().getContentResolver(), "AlmasName", getName);
				MyName.setText(getName);
			
				
			}
		});
		Photo_Picker.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser(intent, "Select Picture"),0);
				
			}
		});
		
	}
	public int getWidth() {
		DisplayMetrics di = getBaseContext().getResources().getDisplayMetrics();
		int w = di.widthPixels-20;
		return w;
	}
	public int getHeight() {
		DisplayMetrics di = getBaseContext().getResources().getDisplayMetrics();
		int h = di.heightPixels-120;
		return h;
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
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	switch (requestCode) {
	
	case 0:
		 if (resultCode == RESULT_OK) {
			 MyUri = Uri.parse(data.getDataString());
			 MyPhoto.setImageURI(MyUri);
			 String setUri = MyUri.toString();
			 Settings.System.putString(getBaseContext().getContentResolver(), "AlmasPhoto", setUri);
		 }
		 break;
	};
	
	
	
	}
	
	
}
