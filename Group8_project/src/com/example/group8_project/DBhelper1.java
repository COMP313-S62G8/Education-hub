package com.example.group8_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.group8_project.Database;

public class DBhelper1 extends SQLiteOpenHelper {
	public static final int DB_VERSION = 1;
	public static final String DB_NAME = "cs.db";
   
	public DBhelper1(Context ctx) {
		super(ctx, DB_NAME, null, DB_VERSION);
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
          createTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}
	
	public void createTables(SQLiteDatabase database) {
		String batches_table_sql = "create table " + Database.BATCHES_TABLE_NAME + " ( " +
				Database.BATCHES_ID 	+ " integer  primary key autoincrement," + 
				Database.BATCHES_BATCHCODE + " TEXT," +
				Database.BATCHES_COURSE + " TEXT," +
				Database.BATCHES_STARTDATE  + " TEXT," +
				Database.BATCHES_STARTTIME + " TEXT," +
				Database.BATCHES_CLASSES + " integer," + 
				Database.BATCHES_PERIOD + " integer," +
				Database.BATCHES_CLASSESPERWEEK + " integer," + 
				Database.BATCHES_REMARKS + " TEXT)";
		
		
		
		String classes_table_sql = "create table " + Database.CLASSES_TABLE_NAME + " ( " +
				Database.CLASSES_CLASSES_ID 	+ " integer  primary key autoincrement," + 
				Database.CLASSES_BATCHCODE + " TEXT," +
				Database.CLASSES_CLASSDATE + " TEXT," +
				Database.CLASSES_CLASSTIME + " TEXT," +
				Database.CLASSES_CLASSPERIOD + " integer," +
				Database.CLASSES_TOPICS+ " TEXT," +
				Database.CLASSES_REMARKS + " TEXT)";
		
        try {
		   database.execSQL(batches_table_sql);
		   database.execSQL("insert into batches (batchcode,course, startdate,starttime,classes,period,classesperweek,remarks)"
				     +   "values ('COMP304','Software Project','2015-04-07','19:00',6,90,6,'Short Course')");
		   
		   database.execSQL(classes_table_sql);
		   
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-07','19:00',90,null,null)");
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-08','19:00',90,null,null)");
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-09','19:00',90,null,null)");
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-10','19:00',90,null,null)");
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-11','19:00',90,null,null)");
		   database.execSQL("insert into classes (batchcode,classdate,classtime,period,topics,remarks)"
				     +   "values ('COMP304','2015-04-12','19:00',90,null,'Last class')");
		   
		   Log.d("CS","Tables created!");
		   
        }
        catch(Exception ex) {
        	Log.d("CS", "Error in DBHelper.onCreate() : " + ex.getMessage());
        }
	}

}

