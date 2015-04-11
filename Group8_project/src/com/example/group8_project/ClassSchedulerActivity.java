package com.example.group8_project;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ClassSchedulerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.main);
        DBhelper1 dbhelper = new DBhelper1(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.close();
        
    }
}