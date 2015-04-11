package com.example.group8_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBhelper extends SQLiteOpenHelper {
	
	private static final String DATA_NAME = "dataname";

	public DBhelper(Context context) {
		super(context, DATA_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}
	
	public static final String SIGNUP = "signup";
	public static final String IDREG = BaseColumns._ID;
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String PASSWORD = "password";
	public static final String SIGNUPAS = "signupas";
	
	public static final String PROFILE = "profile1";
	public static final String IDPRO1 = BaseColumns._ID;
	public static final String FNAME = "fname";
	public static final String LNAME = "lname";
	public static final String DOB = "dob";
	
	public static final String PROFILE2 = "profil2";
	public static final String IDPRO2 = BaseColumns._ID;
	public static final String ADDRESS = "address";
	public static final String COUNTRY = "country";
//	public static final String STATE = "state";
	public static final String CITY = "city";
	public static final String ZIP = "zip";
	
	public static final String PROFILE3 = "profile3";
	public static final String IDPRO3 = BaseColumns._ID;
	public static final String QUALIFICATION = "qualification";
	public static final String INSTUATE = "instuate";
	public static final String YEAR = "year";
	
	public static final String EXPERIENCE = "experience";
	public static final String IDEXP = BaseColumns._ID;
	public static final String ORGANISATION = "organisation";
	public static final String POSITION = "position";
	public static final String YEARS = "years";
	public static final String MONTHS = "months";
	
	public static final String SUBJECTS = "subjects";
	public static final String IDSUB = BaseColumns._ID;
	public static final String SUBJECT = "subject";
	public static final String RS = "rs";
	
	public static final String RESOURCE = "resource";
	public static final String IDRES = BaseColumns._ID;
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String CAT = "cat";

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		 String reg =  " create table " + SIGNUP + " ( " +  IDREG + " integer primary key autoincrement , " 
					+ NAME + " text , " + PASSWORD + " text , " + SIGNUPAS + " text , " + EMAIL + " text , " + PHONE + " text ) ";
				   db.execSQL(reg);
				   
		/* String pro1 =  " create table " + PROFILE + " ( " +  IDPRO1 + " integer primary key autoincrement , " 
					+ FNAME + " text , " + LNAME + " text , " + DOB + " text , " + COUNTRY  + " text , " + QUALIFICATION + " text , " + YEAR + " text ) ";
				   db.execSQL(pro1);*/
				   
		 String pro1 =  " create table " + PROFILE + " ( " +  IDPRO1 + " integer primary key autoincrement , " 
					+ FNAME + " text , " + LNAME + " text , " + DOB + " text ) ";
					db.execSQL(pro1);
					
		 String pro2 =  " create table " + PROFILE2 + " ( " +  IDPRO2 + " integer primary key autoincrement , " 
							+ ADDRESS + " text , " + COUNTRY + " text , " + CITY + " text , " + ZIP + " text ) ";
					db.execSQL(pro2);
					
		 String pro3 =  " create table " + PROFILE3 + " ( " +  IDPRO3 + " integer primary key autoincrement , " 
							+ QUALIFICATION + " text , " + INSTUATE + " text , " + YEAR + " text ) ";
					db.execSQL(pro3);
					
		 String exp =  " create table " + EXPERIENCE + " ( " +  IDEXP + " integer primary key autoincrement , " 
							+ ORGANISATION + " text , " + POSITION + " text , " + YEARS + " text , " + MONTHS + " text ) ";
					db.execSQL(exp);
					
		 String subject =  " create table " + SUBJECTS + " ( " +  IDSUB + " integer primary key autoincrement , " 
							+ SUBJECT + " text , " + RS + " text ) ";
					db.execSQL(subject);
					
		 String res =  " create table " + RESOURCE + " ( " +  IDRES + " integer primary key autoincrement , " 
							+ TITLE + " text , " + DESCRIPTION + " text , " + CAT + " text ) ";
					db.execSQL(res);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}


	

}
