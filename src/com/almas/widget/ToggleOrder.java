package com.almas.widget;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import com.almas.toggles.Helper;
import com.almas.toggles.R;

public class ToggleOrder extends SherlockListActivity {
	 private ListView mButtonList;
	  private ButtonAdapter mButtonAdapter;
	  TouchInterceptor.DropListener mDropListener = new TouchInterceptor.DropListener()
	  {

		@Override
		public void drop(int from, int to) {
			   ArrayList<String> toggles = getToggleFromStringArrary(getBaseContext());
			   if (from < toggles.size()) {
                   String toggle = toggles.remove(from);
                   if (to <= toggles.size()) {
                	   
                       toggles.add(to, toggle);
                       setTogglesFromStringArray(getBaseContext(), toggles); 
                       mButtonAdapter.reloadButtons();
                       mButtonList.invalidateViews();
        			   Intent i =  new Intent();
       				   i.setAction("com.almas.UPDATE");
       				   sendBroadcast(i);
                   }
               }

		}
	    
	  };
	  
	  @Override
      public void onCreate(Bundle icicle) {
          super.onCreate(icicle);
          setContentView(R.layout.toggle_order_activity);
      	this.mButtonList = getListView();
      	((TouchInterceptor)this.mButtonList).setDropListener(this.mDropListener);
      	this.mButtonAdapter = new ButtonAdapter(this);
        setListAdapter(this.mButtonAdapter);
      }
	  @Override
	  public void onDestroy()
	  {
	    ((TouchInterceptor)this.mButtonList).setDropListener(null);
	    setListAdapter(null);
	   
	    super.onDestroy();
	  }
	  @Override
	  public void onResume()
	  {
	    super.onResume();
	  
	    this.mButtonAdapter.reloadButtons();
	    this.mButtonList.invalidateViews();
	  }
	  
	  public static class Toggle {
	        private String mId;
	        private int mTitleResId;

	        public Toggle(String id, int titleResId) {
	            mId = id;
	            mTitleResId = titleResId;
	        }

	        public String getId() {
	            return mId;
	        }

	        public int getTitleResId() {
	            return mTitleResId;
	        }
	    }
	 
	  
	  private class ButtonAdapter extends BaseAdapter {
          private Context mContext;
          private LayoutInflater mInflater;
          private ArrayList<Toggle> mToggles;

          public ButtonAdapter(Context c) {
              mContext = c;
              mInflater = LayoutInflater.from(mContext);

              PackageManager pm = mContext.getPackageManager();
              if (pm != null) {
                  try {
                      pm.getResourcesForApplication("com.almas.widget");
                  } catch (Exception e) {
                     
                  }
              }

              reloadButtons();
          }

          public void reloadButtons() {
              ArrayList<String> toggles = getToggleFromStringArrary(mContext);

              mToggles = new ArrayList<Toggle>();
              for (String toggle : toggles) {
                  mToggles.add(new Toggle(toggle, 0));
              }
          }

          public int getCount() {
              return mToggles.size();
          }

          public Object getItem(int position) {
              return mToggles.get(position);
          }

          public long getItemId(int position) {
              return position;
          }

          public View getView(int position, View convertView, ViewGroup parent) {
              final View v;
              if (convertView == null) {
                  v = mInflater.inflate(R.layout.toggle_order, null);
              } else {
                  v = convertView;
              }

              Toggle toggle = mToggles.get(position);
              final TextView name = (TextView) v.findViewById(R.id.name);
              name.setText(toggle.getId());
              return v;
          }
      }

  

	  public static void setTogglesFromStringArray(Context c, ArrayList<String> newGoodies) {
	        String newToggles = "";

	        for (String s : newGoodies)
	            newToggles += s + " ";

	        // remote last |
	        try {
	            newToggles = newToggles.substring(0, newToggles.length() - 1);
	        } catch (StringIndexOutOfBoundsException e) {
	        }

	        Settings.System.putString(c.getContentResolver(), "AlmasCluster",
	                newToggles);
	    }
	  public static  ArrayList<String> getToggleFromStringArrary(Context ctx) {
		 String My_Cluster = Settings.System.getString(ctx.getContentResolver(), "AlmasCluster");
		
		 if (My_Cluster == null ) {
			 My_Cluster =	Helper.def_clus;
		 }
		 String[] togglesStringArray = My_Cluster.split(" ");
		 ArrayList<String> iloveyou = new ArrayList<String>();
	        for (String s : togglesStringArray) {
	            iloveyou.add(s);
	        }

		 
		return iloveyou;
		 
	  }
	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case android.R.id.home:
	                finish();
	                return true;
	            default:
	                return super.onOptionsItemSelected(item);
	        }
	    }

}
