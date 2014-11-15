package com.almas.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;


    /**
     * Used The Java to get Drawable and layout etc
     * @author Almas
     *
     */
public class AlmasMaster {
	private PackageManager pm;
	private String themePackage = "com.almas.framework";
	public AlmasMaster(Context ctx) {
		pm = ctx.getPackageManager();
	}
	public Drawable getDrawableValue(String name) {
		Resources arc = null;
		Drawable d = null;
		try {
			arc = pm.getResourcesForApplication(themePackage);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		int resource_id = arc.getIdentifier(name,
				"drawable", themePackage);
		if (resource_id != 0) {
			try {
				d = arc.getDrawable(resource_id);
			} catch (Resources.NotFoundException e) {
			}
		}
		return d;
		
	}
	public int getIdValue(String name) {
		Resources arc = null;
		try {
			arc = pm.getResourcesForApplication(themePackage);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		int resource_id = arc.getIdentifier(name, "ids", themePackage);
		
		return resource_id;
		
	}
	public int getLayoutValue(String name) {
		Resources arc = null;
		try {
			arc = pm.getResourcesForApplication(themePackage);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		int resource_id = arc.getIdentifier(name, "layout", themePackage);
		
		return resource_id;
	}
	public int Brightness_Slider() {
		return getLayoutValue("bright_slider");
	}
	public int Eatter_Pop() {
		return getLayoutValue("eatter");
	}
	public int Profile_Pop() {
		return getLayoutValue("profile_set");
	}
	
	public int ST_Pop() {
		return getLayoutValue("screen_timeout");
	}
	
	public Drawable Profile() {
			return getDrawableValue("avatar_default_1");
		
	}
	public Drawable WIFI(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_wifi_on");
		}
		else {
			return getDrawableValue("stat_wifi_off");
		}
		
	}
	public Drawable BT(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_bluetooth_on");
		}
		else {
			return getDrawableValue("stat_bluetooth_off");
		}
		
	}
	public Drawable Data(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_data_on");
		}
		else {
			return getDrawableValue("stat_data_off");
		}
		
	}
	public Drawable GPS(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_gps_on");
		}
		else {
			return getDrawableValue("stat_gps_off");
		}
		
	}
	public Drawable Rotation(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_orientation_on");
		}
		else {
			return getDrawableValue("stat_orientation_off");
		}
		
	}
	public Drawable Airplane(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_airplane_on");
		}
		else {
			return getDrawableValue("stat_airplane_off");
		}
	}
	public Drawable Sound(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_ring_on");
		}
		else {
			return getDrawableValue("stat_ring_off");
		}
		
	}
	public Drawable Bat(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_battery_charging");
		}
		else {
			return getDrawableValue("stat_battey_icon");
		}
		
	}
	public Drawable Sync(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_sync_on");
		}
		else {
			return getDrawableValue("stat_sync_off");
		}
		
	}
	public Drawable Timeout(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_screen_timeout_on");
		}
		else {
			return getDrawableValue("stat_screen_timeout_off");
		}
		
	}
	public Drawable Settings() {
			return getDrawableValue("stat_quicksettings");
	}
	public Drawable Sys_Close() {
		return getDrawableValue("sys_close");
}
	public Drawable Eatter() {
		return getDrawableValue("toggle_eatter");
	}
	public Drawable Hotspot(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_wifi_ap_on");
		}
		else {
			return getDrawableValue("stat_wifi_ap_off");
		}
		
	}
	public Drawable Brithness() {
			return getDrawableValue("stat_brightness_on");
	}
	public Drawable Controller() {
		return getDrawableValue("toggle_control");
		}
	public Drawable Sleep() {

			return getDrawableValue("stat_sleep");	
	}
	public Drawable SS() {

		return getDrawableValue("stat_screenshot");	
		}
	public Drawable LS(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_lock_screen_on");
		}
		else {
			return getDrawableValue("stat_lock_screen_off");
		}
		
	}	
	public Drawable Flash(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_flashlight_on");
		}
		else {
			return getDrawableValue("stat_flashlight_off");
		}
		
	}
	public Drawable Prev() {

		return getDrawableValue("stat_media_previous");	
		}
	public Drawable Play(boolean onoff) {
		if (onoff == true ) {
			return getDrawableValue("stat_media_pause");
		}
		else {
			return getDrawableValue("stat_media_play");
		}
		
	}
	public Drawable Next() {

		return getDrawableValue("stat_media_next");	
		}
	public Drawable Tab() {

		return getDrawableValue("BTN");	
		}
	public Drawable ClearRam() {

			return getDrawableValue("stat_ramkill_on");	
			}public Drawable Reboot() {

				return getDrawableValue("stat_ic_qs_reboot");	
				}
}
