package com.almas.widget;

import android.util.Log;

public class LoggerHelper {
	
	public static void logD(Class<?> name , String msg) {
		String s = "AlmasToggle "+name.getName().toLowerCase();
		Log.d(s, msg);
	}
	public static void logE(Class<?> name , String msg) {
		String s = "AlmasToggle "+name.getName().toLowerCase();
		Log.e(s, msg);
	}

}
