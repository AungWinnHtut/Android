package com.example.adapter;
import com.example.addressbook.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OfficerListAdapter extends BaseAdapter
{
	private ArrayList<String> BC;
	private ArrayList<String> Name;
	private Activity activity;
	public OfficerListAdapter(Activity activity,ArrayList<String> BC,ArrayList<String> NAME)
	{
		super();
		this.BC = BC; 
		this.Name = NAME; 
		this.activity=activity;
	}
	private class ViewHolder
	{
		TextView _BC;
		TextView _Name;
	}
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		final ViewHolder view;
		LayoutInflater inflator=activity.getLayoutInflater();
		final int pp = position;
		if(convertView==null)  
        {  
            view = new ViewHolder();  
            convertView = inflator.inflate(R.layout.addpersontolist , null);  
            view._BC = (TextView) convertView.findViewById(R.id.txtBC);
            view._Name = (TextView) convertView.findViewById(R.id.txtName);
            convertView.setTag(view);  
         }  
         else  
         {  
        	
            view = (ViewHolder) convertView.getTag();  
         }
		
		view._BC.setText(BC.get(position));
       	view._Name.setText(Name.get(position)); 
	    return convertView; 
		
	}
	protected Context getApplicationContext() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	 public int getCount() {  
	      // TODO Auto-generated method stub  
	        return BC.size();  
	    }  
	  
	    public String getItem(int position) {  
	        // TODO Auto-generated method stub  
	        return BC.get(position);  
	    }  
	  
	    public long getItemId(int position) {  
	        // TODO Auto-generated method stub  
	        return 0;  
	    }  
	 
}