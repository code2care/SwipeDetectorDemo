package com.code2care.swipedetectordemo;

import gesture.SwipeDetector;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;

public class SwipeDemo extends Activity {
	private TextView textview;
	private SwipeDetector sd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_demo);
		
		textview = (TextView) findViewById(R.id.textView1);
	     sd = new SwipeDetector(this, new SwipeDetector.OnSwipeListener() {
			
			@Override
			public void onSwipeLeft(float distance, float velocity) {
				
				textview.setText("Swipe Left Detected!");
			}

			@Override
			public void onSwipeRight(float distance, float velocity) {
				textview.setText("Swipe Right Detected!");

			}

			@Override
			public void onSwipeDown(float distance, float velocity) {
				textview.setText("Swipe Down Detected!");

			}
			
			@Override
			public void onSwipeUp(float distance, float velocity) {
				textview.setText("Swipe Up Detected!");
				
			}
		});

	     
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.swipe_demo, menu);
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return sd.onTouch(null, me);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		super.dispatchTouchEvent(ev);
		return sd.onTouchEvent(ev);
	}

}
