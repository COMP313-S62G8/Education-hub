package com.example.group8_project;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
	
	Button login, home, register;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		login=(Button)findViewById(R.id.login1);
		home=(Button)findViewById(R.id.home);
		register=(Button)findViewById(R.id.register1);
		
		
		login.setOnClickListener(this);
		home.setOnClickListener(this);
		register.setOnClickListener(this);
		
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		if(v == login){
			
			Intent i=new Intent(Main.this,Login.class);
			startActivity(i);
			
		}
		
		if(v == home){
			
			Intent i=new Intent(Main.this,Home.class);
			startActivity(i);
			
		}
		
		if(v == register){
			
			Intent i=new Intent(Main.this,Register.class);
			startActivity(i);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
