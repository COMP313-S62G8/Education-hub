package com.example.group8_project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity implements OnClickListener {
	
	ImageView login,signup ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		login = (ImageView)findViewById(R.id.loginhome);
		signup = (ImageView)findViewById(R.id.signuphome);
		
		
		login.setOnClickListener(this);
		signup.setOnClickListener(this);
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		if(v == login){
			
			Intent i=new Intent(Home.this,Login.class);
			startActivity(i);
			
		}
		
		if(v == signup){
			
			Intent i=new Intent(Home.this,Register.class);
			startActivity(i);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	
}
