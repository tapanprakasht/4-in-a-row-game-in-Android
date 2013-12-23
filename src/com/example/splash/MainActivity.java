package com.example.splash;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
    private boolean isBackButtonClicked;
    private final int DURATION=2000;
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView text1=(TextView) findViewById(R.id.textView1);
		TextView text2=(TextView) findViewById(R.id.textView2);
		Typeface face1=Typeface.createFromAsset(getAssets(), "fonts/cu.TTF");
		Typeface face2=Typeface.createFromAsset(getAssets(), "fonts/ravie.TTF");
		text1.setTypeface(face1);
		text2.setTypeface(face2);
		Handler handler=new Handler();
		
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				finish();
				
				if(!isBackButtonClicked)
				{
					Intent myIntent =new Intent(MainActivity.this,Mainmenu.class);
					MainActivity.this.startActivity(myIntent);
					
					
				}
				
			}
		},DURATION);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		isBackButtonClicked=true;
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
