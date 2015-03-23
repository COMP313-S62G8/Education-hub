package com.example.group8_project;


import android.support.v7.appcompat.*;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Login extends Activity implements OnClickListener {
	
	Button login;
	EditText uname,password;
	Spinner sp;
	String s1,s2,s3,s4,s5,st;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		login = (Button)findViewById(R.id.loginLogin);
		uname = (EditText)findViewById(R.id.usernameLogin);
		password = (EditText)findViewById(R.id.passwordLogin);
		
		
		sp = (Spinner)findViewById(R.id.spinnerLogin);
		 sp.setOnItemSelectedListener(new OnItemSelectedListener() {

				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					st = arg0.getItemAtPosition(arg2).toString();
					
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		
		
		login.setOnClickListener(this);
		
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == login){			
			Intent i=new Intent(Login.this,Dashboard.class);			
			startActivity(i);		
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	
}
