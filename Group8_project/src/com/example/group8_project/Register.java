package com.example.group8_project;



import android.support.v7.appcompat.*;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends Activity {

	Button register;
	EditText name,email,phone,password,cpassword;
	Spinner signupas;
	DBhelper h;
	SQLiteDatabase d;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		h = new DBhelper(this);
		
		register = (Button)findViewById(R.id.registerReg);
		 name = (EditText)findViewById(R.id.nameReg);
		 email = (EditText)findViewById(R.id.emailReg);
		 phone = (EditText)findViewById(R.id.phoneReg);
		 password = (EditText)findViewById(R.id.passwordReg);
		 cpassword = (EditText)findViewById(R.id.conformpassReg);
		 signupas = (Spinner)findViewById(R.id.spinnerReg);
		 
		 register.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String Name = name.getText().toString();
				String Email = email.getText().toString();
				String Phone = phone.getText().toString();
				String Password = password.getText().toString();
				String Cpassword = cpassword.getText().toString();	
				String Signupas = (String)signupas.getItemAtPosition(signupas.getSelectedItemPosition());
				   
				boolean valid_username = false;
				
				valid_username=checkUser(Email);
			       
			       
				if(Name.equalsIgnoreCase("")||Email.equalsIgnoreCase("")||Phone.equalsIgnoreCase("")||
		                Password.equalsIgnoreCase("")||Cpassword.equalsIgnoreCase(""))
		        {
		            Toast.makeText(getApplicationContext(), "All Fields Required.", Toast.LENGTH_SHORT).show();
		        }

				else if(Cpassword.equals(Password) == false)
					{
						cpassword.setError("Confirm password does not match");
					}
				else if(!Email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		            {
					    email.setError("Pattern of email is wrong");
					}
				else if(Phone.length()<10)
			         {
			            phone.setError("Contact number must be of 10 digit");
			         }
				else if(valid_username)
					{
						email.setError("Username exist");
					}
				
				else {
				
				d = h.getWritableDatabase();
				
				ContentValues cv =new ContentValues();
				
				cv.put(DBhelper.NAME, Name);
				cv.put(DBhelper.EMAIL, Email);
				cv.put(DBhelper.PASSWORD, Password);
				cv.put(DBhelper.PHONE, Phone);
				cv.put(DBhelper.SIGNUPAS, Signupas);
				
				d.insert(DBhelper.SIGNUP, null, cv);
				d.close();
				Toast.makeText(getApplicationContext(), "Save", 9).show();
				
				Intent i=new Intent(Register.this,Login.class);			
				startActivity(i);
				
				}
				
			}
		});
		
	}
	
	private boolean checkUser(String Email)throws SQLException {
		// TODO Auto-generated method stub

		d = h.getReadableDatabase();
		Cursor c= d.query(DBhelper.SIGNUP, null,DBhelper.EMAIL+"="+"'"+Email+"'", null, null, null, null);
		if(c.moveToFirst()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	
}
