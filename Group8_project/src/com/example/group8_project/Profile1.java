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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile1 extends Activity implements OnClickListener{

	Button submit,browse;
	EditText fname,lname,dob,email,address,country,state,city,qualification,instuate,year;
	ImageView propic;
	DBhelper h;
	SQLiteDatabase d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile1);
		
		h = new DBhelper(this);
		
	//	submit = (Button)findViewById(R.id.submitpro3);
		submit = (Button)findViewById(R.id.submitpro3);
		browse = (Button)findViewById(R.id.browsepro1);
		
	//	browse.setOnClickListener(this);
		
		fname = (EditText)findViewById(R.id.fnamepro1);
		lname = (EditText)findViewById(R.id.lnamepro1);
		dob = (EditText)findViewById(R.id.dobpro1);
		
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String Fname = fname.getText().toString();
				String Lname = lname.getText().toString();
				String Dob = dob.getText().toString();
				
				
				d = h.getWritableDatabase();
				
				ContentValues cv =new ContentValues();
				
				cv.put(DBhelper.FNAME, Fname);
				cv.put(DBhelper.LNAME, Lname);
				cv.put(DBhelper.DOB, Dob);
				
				
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