package com.engineer4myanmar.sundaynaungtest;

import javax.crypto.spec.PSource;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ClipData.Item;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	EditText username,password,phone;
	Button btnAdd,btnDelete,btnModify,btnView;
	SQLiteDatabase db;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.txtusername);
        password=(EditText)findViewById(R.id.txtpassword);
        phone=(EditText)findViewById(R.id.txtphone);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnModify=(Button)findViewById(R.id.btnModify);
        btnView=(Button)findViewById(R.id.btnView);      
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnView.setOnClickListener(this); 
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS profile(username VARCHAR,password VARCHAR,phone VARCHAR);");
    }
    public void onClick(View view)
    {
    	if(view==btnAdd)
    	{
    		if(username.getText().toString().trim().length()==0||
    		   password.getText().toString().trim().length()==0||
    		   phone.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter all values");
    			return;
    		}
    		
    		db.execSQL("INSERT INTO profile VALUES('"+username.getText()+"','"+password.getText()+  "','"+phone.getText()+"');");
    		showMessage("Success", "Record added");
    		clearText();
    	}
    	if(view==btnDelete)
    	{
    		if(username.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter username");
    			return;
    		}
    		Cursor c=db.rawQuery("SELECT * FROM profile WHERE username='"+username.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			db.execSQL("DELETE FROM profile WHERE username='"+username.getText()+"'");
    			showMessage("Success", "Record Deleted");
    		}
    		else
    		{
    			showMessage("Error", "Invalid username");
    		}
    		clearText();
    	}
    	if(view==btnModify)
    	{
    		if(username.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter username");
    			return;
    		}
    		Cursor c=db.rawQuery("SELECT * FROM profile WHERE username='"+username.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			db.execSQL("UPDATE profile SET username='"+username.getText()+"',password='"+password.getText()+
    					"' WHERE username='"+username.getText()+"'");
    			showMessage("Success", "Record Modified");
    		}
    		else
    		{
    			showMessage("Error", "Invalid Rollno");
    		}
    		clearText();
    	}
    	if(view==btnView)
    	{
    		if(username.getText().toString().trim().length()==0)
    		{
    			showMessage("Error", "Please enter Rollno");
    			return;
    		}
    		Cursor c=db.rawQuery("SELECT * FROM profile WHERE username='"+username.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			password    			.setText(c.getString(1));
    			phone.setText(c.getString(2));
    		}
    		else
    		{
    			showMessage("Error", "Invalid username");
    			clearText();
    		}
    	}
    }
    /*	if(view==btnViewAll)
    	{
    		Cursor c=db.rawQuery("SELECT * FROM student", null);
    		if(c.getCount()==0)
    		{
    			showMessage("Error", "No records found");
    			return;
    		}
    		StringBuffer buffer=new StringBuffer();
    		while(c.moveToNext())
    		{
    			buffer.append("Rollno: "+c.getString(0)+"\n");
    			buffer.append("Name: "+c.getString(1)+"\n");
    			buffer.append("Marks: "+c.getString(2)+"\n\n");
    		}
    		showMessage("Student Details", buffer.toString());
    	}
    	if(view==btnShowInfo)
    	{
			showMessage("Student Management Application", "Developed By Azim");
    	}
    }*/
    public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
    public void clearText()
    {
    	username.setText("");
    	password.setText("");
    	phone.setText("");
    	username.requestFocus();
    }
}
