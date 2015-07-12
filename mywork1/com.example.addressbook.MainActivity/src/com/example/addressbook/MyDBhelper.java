package com.example.addressbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBhelper extends SQLiteOpenHelper 
{
	private static final String CREATE_OFFICERTABLE="create table "+
			Constants.Tbl_Officer+ " ("+
			Constants.officerid+" integer primary key autoincrement, "+
			Constants.bc+" text not null, "+
			Constants.rank+" text not null, "+
			Constants.name+" text not null, "+
			Constants.unit+" text not null, "+
			Constants.education+" text not null, "+
			Constants.intake+" text not null, "+
			Constants.address+" text not null, "+
			Constants.ph+" text not null);";
	
	private static final String CREATE_RANKTABLE="create table "+
			Constants.Tbl_Rank+ " ("+
			Constants.RankID+" integer primary key autoincrement, "+
			Constants.Rank+" text not null);";
	
	private static final String CREATE_UNITTABLE="create table "+
			Constants.Tbl_Unit+ " ("+
			Constants.UnitID+" integer primary key autoincrement, "+
			Constants.Unit+" text not null);";
	
	private static final String CREATE_EDUCATIONTABLE="create table "+
			Constants.Tbl_Education+ " ("+
			Constants.EducationID+" integer primary key autoincrement, "+
			Constants.Education+" text not null);";
	
	private static final String CREATE_INTAKETABLE="create table "+
			Constants.Tbl_Intake+ " ("+
			Constants.IntakeID+" integer primary key autoincrement, "+
			Constants.Intake+" text not null);";
	
	public MyDBhelper(Context context,String name, CursorFactory factory, int version)
	{
			super(context,name,factory,version);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		Log.v("MyDBhelper onCreate","Creating all the tables");
		try
		{
			db.execSQL(CREATE_OFFICERTABLE);
			db.execSQL(CREATE_RANKTABLE);
			db.execSQL(CREATE_UNITTABLE);
			db.execSQL(CREATE_EDUCATIONTABLE);
			db.execSQL(CREATE_INTAKETABLE);
			String[] Column={"BC","Name"};
			Cursor C = db.query(Constants.Tbl_Officer,Column, Column[0], null, null, null, null);
		
		}catch(SQLiteException ex)
		{
			Log.v("Create table exception",ex.getMessage());
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
	{
		Log.v("TaskDBAdapter","Upgrading from version " +oldVersion
				+" to "+newVersion +" , Which will destroy all old data");
		db.execSQL("drop table if exists "+Constants.Tbl_Officer);
		onCreate(db);
	}
}