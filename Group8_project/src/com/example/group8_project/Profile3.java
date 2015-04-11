package com.example.group8_project;


import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile3 extends Activity implements OnClickListener {

	TextView qualification,instuate,year;
	Button submit3;
	DBhelper h;
	SQLiteDatabase d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile3);
		
		h = new DBhelper(this);
		
		qualification = (TextView)findViewById(R.id.qualificationpro3);
		instuate = (TextView)findViewById(R.id.instuatepro3);
		year = (TextView)findViewById(R.id.yearpro3);
		submit3 = (Button)findViewById(R.id.submitpro3);
		submit3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Qualification = qualification.getText().toString();
				String Instuate = instuate.getText().toString();
				String Year = year.getText().toString();
				
				d = h.getWritableDatabase();
				
				ContentValues cv =new ContentValues();
				
				cv.put(DBhelper.QUALIFICATION , Qualification);
				cv.put(DBhelper.INSTUATE , Instuate);
				cv.put(DBhelper.YEAR , Year);
			
				
				
				d.insert(DBhelper.PROFILE, null, cv);
				d.close();
				Toast.makeText(getApplicationContext(), "Saved", 9).show();
			}
		});
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

}
