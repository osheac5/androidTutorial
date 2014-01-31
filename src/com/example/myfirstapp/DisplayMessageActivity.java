package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DisplayMessageActivity extends Base_Activity {

	public String message=""; //give all functions access to the user input
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		
		// Show the Up button in the action bar.
		setupActionBar();
        getActionBar().setDisplayHomeAsUpEnabled(true);
		
        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        //get text from intent
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        //Modify Text View to display user input
        TextView messageText = (TextView)  this.findViewById(R.id.message);
        messageText.setText(message);

	}
	
	
	//Function to set up the action bar
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	//Perform relevant actions when Action Bar item is selected
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this); //"Up Button"
			return true;
		case R.id.action_search:
            openSearch();
            return true;
        case R.id.action_settings:
            openSettings();
            return true;
        case R.id.action_fb:
            openFacebook();
            return true;
        case R.id.action_twitter:
            openTwitter();
            return true;
        case R.id.action_call:
            callNumber();
            return true;
        case R.id.action_map:
            openMap();
            return true;
        case R.id.action_web:
            openWeb();
            return true;
        default:
            return super.onOptionsItemSelected(item);
			
		}
	}
	
	//silly functions to deal with the fact that the buttons insist on passing in a view
	public void callNumber(View view){	
		callNumber();
	}
	
	public void openMap(View view){
		openMap();
	}
	
	public void openWeb(View view){
		openWeb();
	}
	
	//pass message on to the phone app
	public void callNumber(){
		
		Uri number = Uri.parse("tel:"+message);
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		startActivity(callIntent);
	}
	
	//pass message on to the maps app
	public void openMap(){

		Uri location = Uri.parse("geo:0,0?q=" + message);
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
		startActivity(mapIntent);
	}
	
	//pass message on to the browser app
	public void openWeb(){
		
		if (message.substring(0, 7) != "http://"){ //insert "http://" as needed
			message = "http://" + message;
		}
		
		Uri webpage = Uri.parse(message);
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, webpage);
		startActivity(browserIntent);
	}
	
}
