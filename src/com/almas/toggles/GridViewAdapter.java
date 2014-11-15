package com.almas.toggles;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridViewAdapter extends BaseAdapter{
	private List<TogglePower> model;
	private Context ctx;
	public GridViewAdapter(Context context, ArrayList<TogglePower> toggles) {
		this.model = toggles;
		this.setCtx(context);
	}

	@Override
	public int getCount() {
		return model.size();
	}

	@Override
	public Object getItem(int arg0) {
		return model.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {

		TogglePower tgl = model.get(arg0);
		return tgl;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
	@Override
	public boolean areAllItemsEnabled()
	{
	    return false;
	}

	@Override
	public boolean isEnabled(int position)
	{
	    return false;
	}
}

