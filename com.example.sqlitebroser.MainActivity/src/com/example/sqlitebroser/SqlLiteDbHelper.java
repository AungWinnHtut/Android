package com.example.sqlitebroser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class SqlLiteDbHelper extends SQLiteOpenHelper {
   // All Static variables
   // Database Version
   private static final int DATABASE_VERSION = 1;
   private static final String DATABASE_PATH = "/data/data/com.example.sqlitebroser/databases/";
   // Database Name
   private static final String DATABASE_NAME = "mycontacts.db";
// Contacts table name
   private static final String TABLE_CONTACT = "contact";
private SQLiteDatabase db;
   // Contacts Table Columns names
   private static final String KEY_ID = "id";
   private static final String KEY_NAME = "name";
   private static final String KEY_EMAILID = "emailid";
   private static final String KEY_MOBILENO = "mobileno";  
   Context ctx;
   public SqlLiteDbHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
      ctx = context;
	  }  
   // Getting single contact
   public Contact Get_ContactDetails(String name) {
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.query(TABLE_CONTACT, new String[] {KEY_ID,KEY_NAME,KEY_EMAILID,KEY_MOBILENO},KEY_NAME +"=?",new String[]{name},null,null,null,null);
if (cursor != null && cursor.moveToFirst()){
             Contact cont = new Contact(cursor.getString(1), cursor.getString(2), cursor.getString(3));
             //return contact
             cursor.close();
             db.close();
             return cont;            
      }
             return null;
   }
   public void CopyDataBaseFromAsset() throws IOException{
      InputStream in  = ctx.getAssets().open(DATABASE_NAME);
      Log.e("sample", "Starting copying" );
      String outputFileName = DATABASE_PATH+DATABASE_NAME;
      File databaseFile = new File( "/data/data/com.example.sqlitebroser/databases/");
       // check if databases folder exists, if not create one and its subfolders
       if (!databaseFile.exists()){
           databaseFile.mkdir();//ဘာလဲဳ
       }     
      OutputStream out = new FileOutputStream(outputFileName);     
      byte[] buffer = new byte[1024];
      int length;    
      while ((length = in.read(buffer))>0){
             out.write(buffer,0,length);
			 }
      Log.e("sample", "Completed" );
      out.flush();
      out.close();
      in.close();     
   }  
   public void openDataBase () throws SQLException{
      String path = DATABASE_PATH+DATABASE_NAME;
      db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
   }
      @Override
      public void onCreate(SQLiteDatabase db) {                       
      }
      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             // TODO Auto-generated method stub            
      }
}

