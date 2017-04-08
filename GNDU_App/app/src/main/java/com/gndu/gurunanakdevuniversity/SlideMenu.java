package com.gndu.gurunanakdevuniversity;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class SlideMenu extends ListActivity {
	private GestureDetector gestureDetector;
	private ImageView iv;
	TextView user;
	Intent 	n;
	public String Message;
	LinearLayout ly;
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 
		 setContentView(R.layout.menu);
		 n=getIntent();
			Message=n.getStringExtra("Message");
			user=(TextView) findViewById(R.id.textView2);
			user.setText(Message);
		    setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Menu)));
		   lv=(ListView)findViewById(android.R.id.list);
                    	
	
			 gestureDetector = new GestureDetector(new SwipeGestureDetector());
			 ly=(LinearLayout)findViewById(R.id.LinearLayout1);
			 
			 ly.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					finish();
					
				}
			});
			 String font="fonts/Roboto-Light.ttf";
			 Typeface tf=Typeface.createFromAsset(getAssets(),font);
				user.setTypeface(tf);
				
	}
	
	
	 /* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		finish();
		//  overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
	}


	@Override
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
	          SlideMenu.this.onLeftSwipe();

	        // Right swipe
	        } else if (-diff > SWIPE_MIN_DISTANCE
	        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
	        	 SlideMenu.this.onRightSwipe();
	        }
	      } catch (Exception e) {
	    	  Toast.makeText(SlideMenu.this,"TError",Toast.LENGTH_LONG).show();
	      }
	      return false;
	    }
	  }
	 @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selectedValue = (String) getListAdapter().getItem(position);
		
		if(selectedValue.equals("Login"))
		{
		  	startActivity(new Intent(SlideMenu.this,Login.class));
		  	 finish();
		}
		else if(selectedValue.equals("Placements"))
		{
			Intent b2=new Intent(SlideMenu.this,Contact_web.class);
			b2.putExtra("Message","http://www.gndu.ac.in/gndu2014/placements.html");
			startActivity(b2);
			 finish();
		}
		else if(selectedValue.equals("About Staff"))
		{
			Intent b=new Intent(SlideMenu.this,Contact_web.class);
			b.putExtra("Message","http://gndu.ac.in/gndu2014/FetchFacultyList.asp");
			startActivity(b);
			 finish();
		}
		else if(selectedValue.equals("History"))
		{
			startActivity(new Intent(SlideMenu.this,History.class));
			 finish();
		}
		else if(selectedValue.equals("About Hostels"))
		{
			startActivity(new Intent(SlideMenu.this,About_Hostels.class));
			 finish();
		}
		else if(selectedValue.equals("Courses"))
		{
			Intent b=new Intent(SlideMenu.this,Contact_web.class);
			b.putExtra("Message","http://www.gndu.ac.in/gndu2014/Gndu_pdf");
			startActivity(b);
			finish();
		
		}
		else if(selectedValue.equals("Other Services"))
		{
			startActivity(new Intent(SlideMenu.this,Other_Services.class));
			 finish();
		}
		else if(selectedValue.equals("Infrastructure"))
		{
			startActivity(new Intent(SlideMenu.this,Infrastracture.class));
		    finish();
		}
		else if(selectedValue.equals("Events"))
		{
			Intent b=new Intent(SlideMenu.this,Contact_web.class);
			b.putExtra("Message","http://www.gndu.ac.in");
			startActivity(b);
			 finish();
		}
		else if(selectedValue.equals("Contacts"))
		{
			startActivity(new Intent(SlideMenu.this,Contact.class));
			 finish();
		}
		
		else if(selectedValue.equals("Syllabus"))
		{
			startActivity(new Intent(SlideMenu.this,Syllabus.class));
			 finish();
		}
		else if(selectedValue.equals("ScholorShip"))
		{
			Intent b=new Intent(SlideMenu.this,Contact_web.class);
			b.putExtra("Message","http://gndu.ac.in/pdf_files/scholarships.pdf");
			startActivity(b);
			 finish();
		}
		else if(selectedValue.equals("UGC"))
		{
			startActivity(new Intent(SlideMenu.this,UGC.class));
			 finish();
		}
		else if(selectedValue.equals("Message From VC"))
		{
			startActivity(new Intent(SlideMenu.this,Message_Of_Vc.class));
			 finish();
		}
		
		
	 }
		

	
}
