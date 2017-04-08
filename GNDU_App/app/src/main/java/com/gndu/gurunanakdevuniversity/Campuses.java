package com.gndu.gurunanakdevuniversity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class Campuses extends Activity {
	private GestureDetector gestureDetector;  
	String str;
	RadioButton rb1,rb2,rb3,rb4,rb5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.campuses); gestureDetector = new GestureDetector(new SwipeGestureDetector());
		rb1=(RadioButton)findViewById(R.id.radioButton1);
		rb2=(RadioButton)findViewById(R.id.radioButton2);
		rb3=(RadioButton)findViewById(R.id.radioButton3);
		rb4=(RadioButton)findViewById(R.id.radioButton4);
		rb5=(RadioButton)findViewById(R.id.radioButton5);
		rb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
		// rb1.setSelected(false);
			 rb2.setSelected(false);
			 rb3.setSelected(false);
			 rb4.setSelected(false);
			 rb5.setSelected(false);
				Intent n=new Intent(Campuses.this,Contact_web.class);
			    n.putExtra("Message","http://www.gndu.ac.in/");
			  
			
			
				startActivity(n);
				
				
			}
		});
rb2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				rb1.setSelected(false);
			//	 rb2.setSelected(false);
				 rb3.setSelected(false);
				 rb4.setSelected(false);
				 rb5.setSelected(false);
				Intent n=new Intent(Campuses.this,Contact_web.class);
				n.putExtra("Message","http://www.gndurcjal.in");
			
				
				startActivity(n);
				
				
				
			}
		});
rb3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	
		rb1.setSelected(false);
		 rb2.setSelected(false);
		// rb3.setSelected(false);
		 rb4.setSelected(false);
		 rb5.setSelected(false);
		Intent n=new Intent(Campuses.this,Contact_web.class);
		n.putExtra("Message","http://www.gndugsp.ac.in/");
	   //  m.str="http://www.gndugsp.ac.in/";
		
		startActivity(n);
		
		
	}
});
rb4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		rb1.setSelected(false);
		 rb2.setSelected(false);
		 rb3.setSelected(false);
		 //rb4.setSelected(false);
		 rb5.setSelected(false);
		Intent n=new Intent(Campuses.this,Contact_web.class);
		n.putExtra("Message","http://gndurcsathiala.org//");
	
		startActivity(n);
		
		
	}
});
rb5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		rb1.setSelected(false);
		 rb2.setSelected(false);
		 rb3.setSelected(false);
		 rb4.setSelected(false);
	//	 rb5.setSelected(false);
		Intent n=new Intent(Campuses.this,Contact_web.class);
		n.putExtra("Message","http://gndu.ac.in/gndu2014/Sultanpur%20Lodhi_campus.html");
		
		startActivity(n);
		
		
	}
});

		ImageView iv=(ImageView) findViewById(R.id.adm);
		
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
				
			}
		});
		
	} @Override
	  public boolean onTouchEvent(MotionEvent event) {
	    if (gestureDetector.onTouchEvent(event)) {
	      return true;
	    }
	    return super.onTouchEvent(event);
	  }

	  private void onLeftSwipe() {
		
		  finish();
	    // Do something
	  }

	  private void onRightSwipe() {
		
	    // Do something
	  }

	  // Private class for gestures
	  private class SwipeGestureDetector
	          extends SimpleOnGestureListener {
	    // Swipe properties, you can change it to make the swipe
	    // longer or shorter and speed
	    private static final int SWIPE_MIN_DISTANCE = 100;
	    private static final int SWIPE_MAX_OFF_PATH = 350;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

	    public boolean onFling(MotionEvent e1, MotionEvent e2,
	                         float velocityX, float velocityY) {
	      try {
	        float diffAbs = Math.abs(e1.getY() - e2.getY());
	        float diff = e1.getX() - e2.getX();

	        if (diffAbs > SWIPE_MAX_OFF_PATH)
	          return false;
	       
	        // Left swipe
	        if (diff > SWIPE_MIN_DISTANCE
	        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
	          Campuses.this.onLeftSwipe();

	        // Right swipe
	        } else if (-diff > SWIPE_MIN_DISTANCE
	        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
	        	 Campuses.this.onRightSwipe();
	        }
	      } catch (Exception e) {
	    	  Toast.makeText(Campuses.this,"TError",Toast.LENGTH_LONG).show();
	      }
	      return false;
	    }
	  }
}