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

public class Profile2 extends Activity implements OnClickListener {

	TextView email,address,country,state,city,zip;
	Button submit2;
	DBhelper h;
	SQLiteDatabase d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile2);
		
		h = new DBhelper(this);
		
		email = (TextView)findViewById(R.id.emailpro2);
		address = (TextView)findViewById(R.id.addresspro2);
		country = (TextView)findViewById(R.id.countrypro2);
		//state = (TextView)findViewById(R.id.statepro2);
		city = (TextView)findViewById(R.id.citypro2);
		zip = (TextView)findViewById(R.id.zippro2);
		submit2 = (Button)findViewById(R.id.submitpro2);
		submit2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String Address = address.getText().toString();
				String Country = country.getText().toString();
			//	String State = state.getText().toString();
				String City = city.getText().toString();
	//			String Zip = zip.getText().toString();
				
				d = h.getWritableDatabase();
				
				ContentValues cv =new ContentValues();
				
				cv.put(DBhelper.ADDRESS, Address);
				cv.put(DBhelper.COUNTRY, Country);
			//	cv.put(DBhelper.STATE, State);
				cv.put(DBhelper.CITY, City);
//				cv.put(DBhelper.ZIP, Zip);
				
			
				
				
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