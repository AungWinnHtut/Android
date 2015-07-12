package com.example.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class detail_officer extends Activity 
{
	Button btnClose;
	EditText txtBC;
	EditText txtName;
	EditText txtRank;
	EditText txtUnit;
	EditText txtEducation;
	EditText txtAddress;
	EditText txtIntake;
	EditText txtPh;
	MyDBhelper _dphelper;
	SQLiteDatabase db;
	Activity activity;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		Bundle bundle = getIntent().getExtras();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_officer);
		txtBC=(EditText)findViewById(R.id.txtDetailOfficerBC);
		txtBC.setText(bundle.getString("BC"));
		txtRank=(EditText)findViewById(R.id.txtDetailOfficerRank);
		txtRank.setText(bundle.getString("Rank"));
		txtName=(EditText)findViewById(R.id.txtDetailOfficerName);
		txtName.setText(bundle.getString("Name"));
		txtUnit=(EditText)findViewById(R.id.txtDetailOfficerUnit);
		txtUnit.setText(bundle.getString("Unit"));
		txtEducation=(EditText)findViewById(R.id.txtDetailOfficerEducation);
		txtEducation.setText(bundle.getString("Education"));
		txtAddress=(EditText)findViewById(R.id.txtDetailOfficerAddress);
		txtAddress.setText(bundle.getString("Address"));
		txtIntake=(EditText)findViewById(R.id.txtDetailOfficerIntake);
		txtIntake.setText(bundle.getString("Intake"));
		txtPh=(EditText)findViewById(R.id.txtDetailOfficerPh);
		txtPh.setText(bundle.getString("Ph"));
		
		btnClose=(Button)findViewById(R.id.btnDetailOfficerClose);
		
		btnClose.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
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

}
