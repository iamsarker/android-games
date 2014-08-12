package com.errorpoint.movetheball.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class LauncherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		playGroundActivty();
		
	}
	
	private void playGroundActivty(){
		Thread splashScreenThread = new Thread(){
			@Override
			public void run(){
				try{
					sleep(2500);
					
				} catch(InterruptedException e){
					
				} finally{
					Intent i = new Intent();
					i.setClassName("com.errorpoint.movetheball.activity", "com.errorpoint.movetheball.activity.PlayGround");
					/* project create er time e jei package name deoa hoi oi package ei activity golo thakte hobe*/
					startActivity(i);
				}
			}
		};
		splashScreenThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher, menu);
		return true;
	}

}
