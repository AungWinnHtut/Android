package com.example.addressbook;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity 
{
	Button btnNew;
	Button btnView;
	Button btnUpdate;
	Button btnExist;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnNew=(Button)findViewById(R.id.btnnew);
		btnView=(Button)findViewById(R.id.btnview);
		btnUpdate=(Button)findViewById(R.id.btnupdate);
		btnExist=(Button)findViewById(R.id.btnexist);
		
		btnNew.setOnClickListener(new OnClickListener()	
		{
			@Override
			public void onClick(View arg0)
			{
				Intent i= new Intent(getApplicationContext(),newperson.class);
				startActivity(i);
			}
		});
		btnView.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0)
			{
				Intent i= new Intent(getApplicationContext(),allperson.class);
				startActivity(i);
				
				
			}
		});
		btnExist.setOnClickListener(new OnClickListener()	
		{
			@Override
			public void onClick(View arg0)
			{
				finish();
				
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onBackPressed()
	{
		finish();
		System.exit(0);
	}

}
