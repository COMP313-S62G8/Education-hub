package com.example.group8_project;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Dashboard extends Activity implements OnClickListener {
	
	ImageView profile,faculty,resource,message,sclass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		faculty = (ImageView)findViewById(R.id.dashsearchfaculty);
		profile = (ImageView)findViewById(R.id.dashprofile);
		resource = (ImageView)findViewById(R.id.dashresource);
		message = (ImageView)findViewById(R.id.dashmessage);
		sclass = (ImageView)findViewById(R.id.dashclass);
		
		faculty.setOnClickListener(this);
		profile.setOnClickListener(this);
		resource.setOnClickListener(this);
		message.setOnClickListener(this);
		sclass.setOnClickListener(this);
		
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == faculty){
			Intent i=new Intent(Dashboard.this,SearchFaculty.class);			
			startActivity(i);
		}
		
		if(v == resource){
			Intent i=new Intent(Dashboard.this,Resources.class);			
			startActivity(i);
		}
		
		if (v== profile){
			Intent i=new Intent(Dashboard.this,Profile.class);			
			startActivity(i);
		}
		
		if(v == message){
			Intent i=new Intent(Dashboard.this, SendEmail.class);
			startActivity(i);
			
		}
		if(v == sclass){
			
			Intent i=new Intent(Dashboard.this, ListBatchesActivity.class);
			startActivity(i);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}

	
}
