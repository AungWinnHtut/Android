package com.example.addressbook;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.example.addressbook.R;
import com.example.addressbook.MyDBhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class allperson extends Activity 
{
	ArrayList BC;
	ArrayList Name;
	ArrayList Rank;
	ArrayList Unit;
	ArrayList Education;
	ArrayList Intake;
	ArrayList Address;
	ArrayList Ph;
	
	MyDB dba;
	AllPersonAdapter myAdapter;
	ListView list;
	Button BtnBack;
	private class Officers
	{

		public String bc;
		public String rank;
		public String name;
		public String unit;
		public String education;
		public String intake;
		public String address;
		public String ph;
		public Officers(String BC,String RANK,String NAME,String UNIT,String EDUCATION,String INTAKE,String ADDRESS,String PH)
		{
			bc=BC;
			rank=RANK;
			name=NAME;
			unit=UNIT;
			education=EDUCATION;
			intake=INTAKE;
			address=ADDRESS;
			ph=PH;
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		dba= new MyDB(this);
		dba.open();
		BC=new ArrayList<String>();
		Rank=new ArrayList<String>();
		Name=new ArrayList<String>();
		Unit=new ArrayList<String>();
		Education=new ArrayList<String>();
		Intake=new ArrayList<String>();
		Address=new ArrayList<String>();
		Ph=new ArrayList<String>();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allperson);
		BtnBack=(Button)findViewById(R.id.btnBack);
		 BtnBack.setOnClickListener(new OnClickListener()	
			{
				@Override
				public void onClick(View arg0)
				{
					finish();
				}
			});
		Cursor C=dba.get_officers();
		 while(C.moveToNext())
		 {
			 BC.add(C.getString(1));
			 Rank.add(C.getString(3));
			 Name.add(C.getString(2));
			 Unit.add(C.getString(4));
			 Education.add(C.getString(5));
			 Intake.add(C.getString(7));
			 Address.add(C.getString(6));
			 Ph.add(C.getString(8));
		 }
		 
		 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		list =(ListView)findViewById(R.id.LV_Officer);
		myAdapter = new AllPersonAdapter(this);
		list.setAdapter(myAdapter);
		list.setOnItemClickListener(new OnItemClickListener() 
	    {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id)
	    	{
	    		Intent i = new Intent(getApplicationContext(), detail_officer.class);
	    		i.putExtra("BC", BC.get(position).toString());
	    		i.putExtra("Rank", Rank.get(position).toString());
	    		i.putExtra("Name", Name.get(position).toString());
	    		i.putExtra("Unit", Unit.get(position).toString());
	    		i.putExtra("Education", Education.get(position).toString());
	    		i.putExtra("Intake", Intake.get(position).toString());
	    		i.putExtra("Address", Address.get(position).toString());
	    		i.putExtra("Ph", Ph.get(position).toString());
	    		startActivity(i);
	    	}
	    });
	}
	
	private class AllPersonAdapter extends BaseAdapter
	{
		private ArrayList BC;
		private ArrayList Name;
		private ArrayList Rank;
		private ArrayList Unit;
		private ArrayList Education;
		private ArrayList Intake;
		private ArrayList Address;
		private ArrayList Ph;
		private Activity activity;
		private LayoutInflater mInflater;
		private ArrayList<Officers> officers;
		
		public AllPersonAdapter(Activity activity)
		{
			super();
			this.activity=activity;
			
			mInflater = LayoutInflater.from(activity);
			officers = new ArrayList<Officers>();
			getdata();
		}
		public void getdata()
		{
			Cursor c=dba.get_officers();
			startManagingCursor(c);
			if(c.moveToFirst())
			{
				do{
					//String bc = c.getString(c.getColumnIndex(Constants.bc));
					//String rank = c.getString(c.getColumnIndex(Constants.rank));
					String name = c.getString(c.getColumnIndex(Constants.name));
					String unit = c.getString(c.getColumnIndex(Constants.unit));
					String education = c.getString(c.getColumnIndex(Constants.education));
					String intake = c.getString(c.getColumnIndex(Constants.intake));
					String address = c.getString(c.getColumnIndex(Constants.address));
					String ph = c.getString(c.getColumnIndex(Constants.ph));
					Officers temp = new Officers( c.getString(c.getColumnIndex(Constants.bc)),c.getString(c.getColumnIndex(Constants.rank)),name,unit,education,intake,address,ph);
					officers.add(temp);
				}while (c.moveToNext());
			}
		}
		
	
		@Override
		public int getCount()
		{
			return officers.size();
		}
		public Officers getItem(int i)
		{
			return officers.get(i);
		}
		public long getItemId(int i)
		{
			return i;
		}
		public View getView(int arg0,View arg1, ViewGroup arg2)
		{
			final ViewHolder holder;
			View v=arg1;
			if((v==null) || (v.getTag()==null))
			{
				v=mInflater.inflate(R.layout.addpersontolist, null);
				holder = new ViewHolder();
				holder.mBC = (TextView)v.findViewById(R.id.txtBC);
				holder.mName = (TextView)v.findViewById(R.id.txtName);
				v.setTag(holder);
			}
			else
			{
				holder =(ViewHolder)v.getTag();
			}
			
			holder.officer = getItem(arg0);
			holder.mBC.setText(holder.officer.bc);
			holder.mName.setText(holder.officer.name);
			
			v.setTag(holder);
			return v;
		}
		public class ViewHolder
		{
			Officers officer;
			TextView mBC;
			TextView mName;
			
		}
	}

	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*MyDB dba;
	AllPersonAdapter myAdapter;
	ArrayList BC;
	ArrayList Name;
	ArrayList Rank;
	ArrayList Unit;
	ArrayList Education;
	ArrayList Intake;
	ArrayList Address;
	ArrayList Ph;
	TextView _BC;
	TextView _Officer;
	MyDBhelper _dphelper;
	//IntakeListAdapter myAdapter;
	ListView myListView;
	Activity activity;
	Button BtnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allperson);
		activity = this;
		Name = new ArrayList<String>();
		BC = new ArrayList<String>();
		Rank = new ArrayList<String>();
		Unit = new ArrayList<String>();
		Education = new ArrayList<String>();
		Address = new ArrayList<String>();
		Intake = new ArrayList<String>();
		Ph = new ArrayList<String>();
		BtnBack=(Button)findViewById(R.id.btnBack);
		
		_dphelper=new MyDBhelper(this);
		
		String[] Column={"BC","Name","Rank","Unit","Education","Intake","Address","Ph"};
		Cursor C= _dphelper.getDataFromdb("VW1",Column,null,null,null,null,null);
		while(C.moveToNext())
		{
			BC.add(C.getString(0));
			Name.add(C.getString(1));
			Rank.add(C.getString(2));
			Unit.add(C.getString(3));
			Education.add(C.getString(4));
			Intake.add(C.getString(5));
			Address.add(C.getString(6));
			Ph.add(C.getString(7));
				
		}
		Toast prName = Toast.makeText(activity.getApplicationContext(),Integer.toString(BC.size()), 	
				Toast.LENGTH_SHORT);
		prName.setGravity(Gravity.AXIS_SPECIFIED, 0, 0);
	    prName.show();
	    myAdapter = new IntakeListAdapter(activity, BC,Name);
		myListView = (ListView) findViewById(R.id.LV_Officer);  
		myAdapter.notifyDataSetChanged();
		myListView.setAdapter(myAdapter);
		registerForContextMenu(myListView);	
	    
	    myListView.setOnItemClickListener(new OnItemClickListener() 
	    {
	    	public void onItemClick(AdapterView<?> parent, View v,int position, long id)
	    	{
	    		Intent i = new Intent(getApplicationContext(), detail_officer.class);
	    		i.putExtra("BC", BC.get(position).toString());
	    		i.putExtra("Rank", Rank.get(position).toString());
	    		i.putExtra("Name", Name.get(position).toString());
	    		i.putExtra("Unit", Unit.get(position).toString());
	    		i.putExtra("Education", Education.get(position).toString());
	    		i.putExtra("Intake", Intake.get(position).toString());
	    		i.putExtra("Address", Address.get(position).toString());
	    		i.putExtra("Ph", Ph.get(position).toString());
	    		startActivity(i);
	    	}
	    });
	    
	    
	    BtnBack.setOnClickListener(new OnClickListener()	
		{
			@Override
			public void onClick(View arg0)
			{
				finish();
			}
		});
	}*/

}
