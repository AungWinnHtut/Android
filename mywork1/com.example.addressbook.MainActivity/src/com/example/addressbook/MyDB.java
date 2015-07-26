package com.example.addressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;


public class MyDB 
{
	private SQLiteDatabase db;
	private final Context context;
	private final MyDBhelper dbhelper;
	public MyDB(Context c)
	{
		context=c;
		dbhelper= new MyDBhelper(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
	}
	public void close()
	{
		db.close();
	}
	public void open() throws SQLiteException
	{
		try
		{
			db = dbhelper.getWritableDatabase();
		}catch(SQLiteException ex)
		{
			Log.v("Open database exception caught", ex.getMessage());
			db=dbhelper.getReadableDatabase();
		}
	}
	public long insert_officer(String BC,String Rank,String Name,String Unit,String Education,String Intake,String Address,String Ph)
	{
		try
		{
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.bc, BC);
			newTaskValue.put(Constants.rank, Rank);
			newTaskValue.put(Constants.name, Name);
			newTaskValue.put(Constants.unit, Unit);
			newTaskValue.put(Constants.education, Education);
			newTaskValue.put(Constants.intake, Intake);
			newTaskValue.put(Constants.address, Address);
			newTaskValue.put(Constants.ph, Ph);
			return db.insert(Constants.Tbl_Officer, null, newTaskValue);
			
			
		}catch(SQLiteException ex)
		{
			Log.v("Insert into database exception caught ", ex.getMessage());
			return -1;
		}
	}
	public Cursor get_officers()
	{
		Cursor c = db.query(Constants.Tbl_Officer,null,null,null,null,null,null);
		return c;
	}
}
