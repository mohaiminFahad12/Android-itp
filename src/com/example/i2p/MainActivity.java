package com.example.i2p;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ImageView im;
	TextView tv;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		im = (ImageView) findViewById(R.id.imageView1);
		
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
		im.startAnimation(animation);
		
		tv = (TextView) findViewById(R.id.textView1);
		Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
		tv.startAnimation(animation2);
		
		btn = (Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, name_inputClass.class);
				startActivity(it);
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
