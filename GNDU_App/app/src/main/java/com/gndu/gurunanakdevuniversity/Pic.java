package com.gndu.gurunanakdevuniversity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pic extends Activity 
{

	ImageView iv;	Intent 	n;
	TextView tv;
	Button btok;
	public String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		n=getIntent();
		str=n.getStringExtra("Src");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pic);
		tv=(TextView) findViewById(R.id.cname);
		btok=(Button)findViewById(R.id.minfo);
		btok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				startActivity(new Intent(Pic.this,Campuses.class));
				finish();
			}
		});
		iv=(ImageView)findViewById(R.id.imageView1);
		if(str.equals("1"))
		{
			iv.setImageResource(R.drawable.gndue);
			tv.setText("Guru Nanak Dev University Main Campus");
			
		}
		else if(str.equals("2"))
		{iv.setImageResource(R.drawable.camrcjal);
		tv.setText("Guru Nanak Dev University RC Jalandhar");
		}
		else if(str.equals("3"))
		{
			iv.setImageResource(R.drawable.gur);
			tv.setText("Guru Nanak Dev University RC Gurdaspur");
		}
		else if(str.equals("4"))
		{
			iv.setImageResource(R.drawable.sath);
			tv.setText("Guru Nanak Dev University RC Sathiala");
		}
		else if(str.equals("5"))
		{
			iv.setImageResource(R.drawable.lodh);
			tv.setText("Guru Nanak Dev University RC SultanPur Lodhi");
		}
		
		
	
	
	
		
	}
}
