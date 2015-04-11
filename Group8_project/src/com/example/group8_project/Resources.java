package com.example.group8_project;


import java.io.File;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.android.AuthActivity;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



public class Resources extends Activity {

	private Button browse;
	private EditText desc;
	private ImageButton dropbox;
	private static final String TAG = "DBRoulette";
    private static final String APP_KEY = "gkntaktv81e6olz";
    private static final String APP_SECRET = "09tnget4br5x8ni";
    private static final String ACCOUNT_PREFS_NAME = "prefs";
    private static final String ACCESS_KEY_NAME = "ACCESS_KEY";
    private static final String ACCESS_SECRET_NAME = "ACCESS_SECRET";
    private File selectedfile;
    private Button submit;
    private static final boolean USE_OAUTH1 = false;
    private final String Myresource = "/Myresource/";
    DropboxAPI<AndroidAuthSession> mApi;

    private boolean mLoggedIn;
	
	private final int REQUEST_FILE=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 AndroidAuthSession session = buildSession();
	     mApi = new DropboxAPI<AndroidAuthSession>(session);
	     
	     setContentView(R.layout.activity_resources);
	     checkAppKeySetup();
	     
	     browse=(Button) findViewById(R.id.browseRes);
		 desc=(EditText) findViewById(R.id.DescriptionRes);
		 dropbox=(ImageButton) findViewById(R.id.dropbox);
		 submit=(Button) findViewById(R.id.submitRes);
		 
		 dropbox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mLoggedIn) {
                    logOut();
                } else {
                    // Start the remote authentication
                    if (USE_OAUTH1) {
                        mApi.getSession().startAuthentication(Resources.this);
                    } else {
                        mApi.getSession().startOAuth2Authentication(Resources.this);
                    }
                }
			}
		});
		 
		
		browse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent intent = new Intent();
			      intent.setAction(Intent.ACTION_GET_CONTENT);
			      intent.setType("file/*");
			     
				startActivityForResult(intent, REQUEST_FILE);
			}
		});
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				UploadFile upload = new UploadFile(Resources.this, mApi, Myresource, selectedfile);
                upload.execute();
			}
		});
		
	}
	
	
	private void logOut() {
        // Remove credentials from the session
        mApi.getSession().unlink();

        // Clear our stored keys
        clearKeys();
        // Change UI state to display logged out version
        setLoggedIn(false);
    }
	
	
	
	 @Override
	    protected void onResume() {
	        super.onResume();
	        AndroidAuthSession session = mApi.getSession();

	        // The next part must be inserted in the onResume() method of the
	        // activity from which session.startAuthentication() was called, so
	        // that Dropbox authentication completes properly.
	        if (session.authenticationSuccessful()) {
	            try {
	                // Mandatory call to complete the auth
	                session.finishAuthentication();

	                // Store it locally in our app for later use
	                storeAuth(session);
	                setLoggedIn(true);
	            } catch (IllegalStateException e) {
	                showToast("Couldn't authenticate with Dropbox:" + e.getLocalizedMessage());
	                Log.i(TAG, "Error authenticating", e);
	            }
	        }
	    }
	 
	 private void storeAuth(AndroidAuthSession session) {
	        // Store the OAuth 2 access token, if there is one.
	        String oauth2AccessToken = session.getOAuth2AccessToken();
	        if (oauth2AccessToken != null) {
	            SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
	            Editor edit = prefs.edit();
	            edit.putString(ACCESS_KEY_NAME, "oauth2:");
	            edit.putString(ACCESS_SECRET_NAME, oauth2AccessToken);
	            edit.commit();
	            return;
	        }
	        // Store the OAuth 1 access token, if there is one.  This is only necessary if
	        // you're still using OAuth 1.
	        AccessTokenPair oauth1AccessToken = session.getAccessTokenPair();
	        if (oauth1AccessToken != null) {
	            SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
	            Editor edit = prefs.edit();
	            edit.putString(ACCESS_KEY_NAME, oauth1AccessToken.key);
	            edit.putString(ACCESS_SECRET_NAME, oauth1AccessToken.secret);
	            edit.commit();
	            return;
	        }
	    }
	
	
	 private void setLoggedIn(boolean loggedIn) {
	    	mLoggedIn = loggedIn;
	    	if (loggedIn) {
	    		dropbox.setImageResource(R.drawable.dropboxicon);
	    		//dropbox.setVisibility(View.VISIBLE);
	    	} else {
	    		dropbox.setImageResource(R.drawable.dropboxred);
	            //mDisplay.setVisibility(View.GONE);
	           // mImage.setImageDrawable(null);
	    	}
	    }
	
	private void clearKeys() {
        SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        Editor edit = prefs.edit();
        edit.clear();
        edit.commit();
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==REQUEST_FILE){
			if(resultCode == Activity.RESULT_OK){
				Uri path=data.getData();
			//	Cursor c = getContentResolver().query(
			//		    path,null,null,null,null);
			//		c.moveToNext();
			//		String realpath = c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
			//		c.close();
				
				desc.setText(path.toString());
				
				
				selectedfile=new File(path.getPath());
				
			}
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resources, menu);
		return true;
	}
	
	
	private void checkAppKeySetup() {
        // Check to make sure that we have a valid app key
        if (APP_KEY.startsWith("CHANGE") ||
                APP_SECRET.startsWith("CHANGE")) {
            showToast("You must apply for an app key and secret from developers.dropbox.com, and add them to the DBRoulette ap before trying it.");
            finish();
            return;
        }

        // Check if the app has set up its manifest properly.
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        String scheme = "db-" + APP_KEY;
        String uri = scheme + "://" + AuthActivity.AUTH_VERSION + "/test";
        testIntent.setData(Uri.parse(uri));
        PackageManager pm = getPackageManager();
        if (0 == pm.queryIntentActivities(testIntent, 0).size()) {
            showToast("URL scheme in your app's " +
                    "manifest is not set up correctly. You should have a " +
                    "com.dropbox.client2.android.AuthActivity with the " +
                    "scheme: " + scheme);
            finish();
        }
    }
	
	 private void showToast(String msg) {
	        Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
	        error.show();
	    }
	
	private AndroidAuthSession buildSession() {
        AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_SECRET);

        AndroidAuthSession session = new AndroidAuthSession(appKeyPair);
        loadAuth(session);
        return session;
    }
	private void loadAuth(AndroidAuthSession session) {
        SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        String key = prefs.getString(ACCESS_KEY_NAME, null);
        String secret = prefs.getString(ACCESS_SECRET_NAME, null);
        if (key == null || secret == null || key.length() == 0 || secret.length() == 0) return;

        if (key.equals("oauth2:")) {
            // If the key is set to "oauth2:", then we can assume the token is for OAuth 2.
            session.setOAuth2AccessToken(secret);
        } else {
            // Still support using old OAuth 1 tokens.
            session.setAccessTokenPair(new AccessTokenPair(key, secret));
        }
    }
	
	
	
	
	


}
