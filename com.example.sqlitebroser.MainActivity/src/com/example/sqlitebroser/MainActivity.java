package com.example.sqlitebroser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	TextView contact;
	ListView liststudents;
	EditText name;
	Sqlconnector sqlconnector;
	Button insert;
	// TableLayout liststudents;
	SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(this);
	//////////////////////
	private SQLiteDatabase database;
	private Cursor cursor;
	
	private static final String Tbl = "contact";
	////////////////////////
	// Contact contacts ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// liststudents=(TableLayout)findViewById(R.id.liststudents);
		insert = (Button) findViewById(R.id.insert);
		name=(EditText)findViewById(R.id.N);
		insert.setOnClickListener(this);
		liststudents = (ListView) findViewById(R.id.liststudents);
		sqlconnector = new Sqlconnector(this);

		// contact = (TextView)findViewById(R.id.contact);
		dbHelper = new SqlLiteDbHelper(this);
		try {
			dbHelper.CopyDataBaseFromAsset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbHelper.openDataBase();

	
		final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				sqlconnector.getAllRecord(1));
	
		liststudents.setAdapter(adapter1);
		
		// liststudents.setOnClickListener(l)
		// liststudents.addView(adapter2);
		// contacts = new Contact();
		// contacts = dbHelper.Get_ContactDetails("vijay");
		// contact.setText(contacts.name +"\n" +contacts.email +"\n"
		// +contacts.mobileNo);
	}
	public void onClick(View view) {
		dbHelper.openDataBase();
		if (view == insert) {
			sqlconnector.insert(name.getText().toString());
			//db.execSQL("INSERT INTO contact VALUES('" + N.getText()	+ "');");
		}
	}
	
	
	public List<String> getAllRecord(int k) {
		List<String> studentlist = new ArrayList<String>();
		String selectquery = "SELECT * FROM " + Tbl;
		File dbf = new File("/data/data/com.example.sqlitebroser/databases/mycontacts.db");
		database = SQLiteDatabase.openOrCreateDatabase(dbf,null);
		cursor = database.rawQuery(selectquery, null);
		if (cursor.moveToFirst()) {
			do {
				studentlist.add(cursor.getString(k));
			} while (cursor.moveToNext());

		}

		database.close();
		return studentlist;
	}
	
	
	public void insert(String name1){
		File dbf = new File("/data/data/com.example.sqlitebroser/databases/mycontacts.db");
		database = SQLiteDatabase.openOrCreateDatabase(dbf,null);
		database.execSQL("INSERT INTO contact VALUES(null,'"+name1+"',null,null);");
		database.close();
	}
	
	
	public void funShowAll(View v)
	{
		final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				sqlconnector.getAllRecord(1));
	
		liststudents.setAdapter(adapter1);
	}
	
}
