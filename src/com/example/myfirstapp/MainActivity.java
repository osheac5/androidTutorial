package com.example.myfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Base_Activity {
	
	public String previousState="";	//variable to hold the state previously occupied by the activity
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	//Override onCreate to update state variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        previousState = "\"created\"";
        	
    }

    //Override onStart to update state variables
    @Override
    protected void onStart() {
        super.onStart();
        
        String state = "started";
        outputActivityState(state);
        
        previousState = "\"started\"";
        
    }

    //Override onRestart to update state variables
    @Override
    protected void onRestart() {
        super.onRestart();
        
        String state = "restarted";
        outputActivityState(state);
        
        previousState = "\"restarted\"";
        
    }
    
    
    //Override onResume to update state variables    
	@Override
    public void onResume() {
        super.onResume();
        
        String state = "resumed";
        outputActivityState(state);
        
        previousState = "\"resumed\"";
    }

	//Override onPause to update state variables
    @Override
    public void onPause() {
        super.onPause();
        
        String state = "paused";
        outputActivityState(state);
        
        previousState = "\"paused\"";

    }
    
    //Override onStop to update state variables
    @Override
    protected void onStop() {
        super.onStop();
        
        String state = "stopped";
        outputActivityState(state);
        
        previousState = "\"stopped\"";

    }
    
    //Create and format the Text View showing the state of the activity
    private void outputActivityState(String state) {
    	state = "I've been \"" + state;
    	state = state + "\" after being " + previousState;
        TextView activity_state = (TextView)findViewById(R.id.activity_state);
        activity_state.setTextSize(20);
        activity_state.setText(state);
        activity_state.setX(10);
        activity_state.setY(100);
    }

	//Called when "Send" button clicked
    public void sendMessage(View view){
    	
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    //Open a dialogue (stubbornly spelled "correctly" apparently! ..still not used to being forced into American spelling by code!)
    //...when "pause" button clicked
    public void openDialogue(View view){
    	
    	Intent intent = new Intent(this, DialogTActivity.class);
        startActivity(intent);
    	

    }

    
}
