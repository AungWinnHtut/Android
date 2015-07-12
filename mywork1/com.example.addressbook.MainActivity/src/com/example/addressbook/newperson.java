package com.example.addressbook;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class newperson extends Activity 
{
	Button btnSave;
	Button btnBack;
	EditText txtBC;
	EditText txtName;
	EditText txtRank;
	EditText txtUnit;
	EditText txtEducation;
	EditText txtAddress;
	EditText txtIntake;
	EditText txtPh;
	MyDB dba;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newperson);
		dba=new MyDB(this);
		dba.open();
		
		txtBC=(EditText)findViewById(R.id.txtBc);
		txtRank=(EditText)findViewById(R.id.txtRank);
		txtName=(EditText)findViewById(R.id.Name);
		txtUnit=(EditText)findViewById(R.id.txtUnit);
		txtEducation=(EditText)findViewById(R.id.txtEducation);
		txtAddress=(EditText)findViewById(R.id.txtAddress);
		txtIntake=(EditText)findViewById(R.id.txtIntake);
		txtPh=(EditText)findViewById(R.id.txtPh);
		btnSave=(Button)findViewById(R.id.btnSave);
		btnBack=(Button)findViewById(R.id.btnNewpersonBack);
		btnSave.setOnClickListener(new OnClickListener() 
		{

		        public void onClick(View arg0) 
		        {
		        	
		        	try
		        	{
		        		saveItToDB();
		        	}catch (Exception e)
		        	{
		        		e.printStackTrace();
		        	}
		        }
		    });
		btnBack.setOnClickListener(new OnClickListener() 
		{

		        public void onClick(View arg0) 
		        {
		        	
		        	finish();
		        }
		    });
				
	}
	public void saveItToDB()
	{
		dba.insert_officer(txtBC.getText().toString(), txtRank.getText().toString(), txtName.getText().toString(), txtUnit.getText().toString(), txtEducation.getText().toString(), txtAddress.getText().toString(), txtIntake.getText().toString(), txtPh.getText().toString());
		dba.close();
		txtBC.setText("");
		txtRank.setText("");
		txtName.setText("");
		txtUnit.setText("");
		txtEducation.setText("");
		txtAddress.setText("");
		txtIntake.setText("");
		txtPh.setText("");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
