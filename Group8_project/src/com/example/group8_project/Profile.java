package com.example.group8_project;


import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Profile extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
 
		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
 
		// Android tab
		Intent intentAndroid = new Intent().setClass(this, Profile1.class);
		TabSpec tabSpecAndroid = tabHost
		  .newTabSpec("a")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon))
		  .setContent(intentAndroid);
 
		// Apple tab
		Intent intentApple = new Intent().setClass(this, Profile2.class);
		TabSpec tabSpecApple = tabHost
		  .newTabSpec("b")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon))
		  .setContent(intentApple);
 
		// Windows tab
		Intent intentWindows = new Intent().setClass(this, Profile3.class);
		TabSpec tabSpecWindows = tabHost
		  .newTabSpec("c")
		  .setIndicator("", ressources.getDrawable(R.drawable.icon))
		  .setContent(intentWindows);
 
 
		// add all tabs 
		tabHost.addTab(tabSpecAndroid);
		tabHost.addTab(tabSpecApple);
		tabHost.addTab(tabSpecWindows);
	
 
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}
 

}
