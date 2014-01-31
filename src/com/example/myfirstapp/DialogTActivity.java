package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

//Dialog activity to demonstrate visible "paused" state
public class DialogTActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog_t);
	}
	
	//Finish activity when "Resume" button pressed
    public void finishDialog(View view) {
        this.finish();
    }

}
