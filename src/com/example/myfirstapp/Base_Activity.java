package com.example.myfirstapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Base_Activity extends Activity { //Base Activity Template
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.action_menu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	//Perform relevant actions when Action Bar item is selected
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
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
        default:
            return super.onOptionsItemSelected(item);
			
		}
	}
	
	//Open "Search" (google.com)
	public void openSearch(){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
		startActivity(browserIntent);
	}
	
	//Dummy function for Settings as there are no settings
	public void openSettings(){
		;
	}
	
	//Open Facebook in the browser / app if it exists
	public void openFacebook(){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
		startActivity(browserIntent);
	}
	
	//Open Twitter in the browser / app if it exists
	public void openTwitter(){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com"));
		startActivity(browserIntent);
	}

}
