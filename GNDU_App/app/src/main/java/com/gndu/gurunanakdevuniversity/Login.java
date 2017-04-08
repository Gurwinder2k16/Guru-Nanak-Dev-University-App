package com.gndu.gurunanakdevuniversity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Login extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.login);
	ImageView iv=(ImageView) findViewById(R.id.imageView3);
	iv.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v)
		{
			
			
			finish();
			
		}
	});
	
	}

}
