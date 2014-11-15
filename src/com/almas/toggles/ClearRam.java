package com.almas.toggles;

import java.io.RandomAccessFile;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

public class ClearRam extends TogglePower {
    double totalMemory = 0;
    double availableMemory = 0;
	public ClearRam(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onToggleClick() {
		
		// Credit to tentenponce
		 ActivityManager am = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
         List<ActivityManager.RunningAppProcessInfo> runningapptasks = am.getRunningAppProcesses();
         List<ActivityManager.RecentTaskInfo> recent_tasks = am.getRecentTasks(Integer.MAX_VALUE, ActivityManager.RECENT_WITH_EXCLUDED);
         List<ActivityManager.RunningTaskInfo> runningtaskss =am.getRunningTasks(Integer.MAX_VALUE);
         for (ActivityManager.RunningTaskInfo runningtasks : runningtaskss) {
             String packageName = runningtasks.baseActivity.getPackageName();
             am.killBackgroundProcesses(packageName);
             am.restartPackage(packageName);
         }

         for (ActivityManager.RunningAppProcessInfo runningapptask : runningapptasks) {
             am.restartPackage(runningapptask.processName);
         }
         am.restartPackage("com.android.music");
         for (ActivityManager.RecentTaskInfo recent_task : recent_tasks) {
             String LocalApp = recent_task.baseIntent + "";
             int indexPackageNameBegin = LocalApp.indexOf("cmp=") + 4;
             int indexPackageNameEnd = LocalApp.indexOf("/", indexPackageNameBegin);
             String PackageName = LocalApp.substring(indexPackageNameBegin, indexPackageNameEnd);
             am.killBackgroundProcesses(PackageName);
             am.restartPackage(PackageName);
         }
         if(totalMemory == 0) {
             try {
                 @SuppressWarnings("resource")
				RandomAccessFile reader = new RandomAccessFile("/proc/meminfo", "r");
                 String load = reader.readLine();
                 String[] memInfo = load.split(" ");
                 totalMemory = Double.parseDouble(memInfo[9])/1024;

             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }

         ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
         am.getMemoryInfo(mi);
         availableMemory = mi.availMem / 1048576L;
         int usedmemory = (int) (totalMemory - availableMemory);
         int totmem = (int) totalMemory;
         Toast.makeText(getContext(), "RAM Cleared! " +usedmemory +" MB/" +totmem +" MB", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onToggleLongClick() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName("com.android.settings", "com.android.settings.RunningServices");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
		
	}

	@Override
	public String getLabel() {
		return "Clear Ram";
	}


	@Override
	public boolean getStatus() {
		return false;
	}

	@Override
	public void onTogglerObserver() {
		TogglesObserver tg = new TogglesObserver();
		tg.observe(getContext(), getRootView(), tCr);
		
	}

	@Override
	public Drawable getIconOn() {
		return am.ClearRam();
	}

	@Override
	public Drawable getIconOff() {
		return am.ClearRam();
	}

}
