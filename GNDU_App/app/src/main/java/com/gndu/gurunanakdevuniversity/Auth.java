package com.gndu.gurunanakdevuniversity;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.OAEPParameterSpec;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Auth extends Activity {
	Button bt,bt1;
	EditText et;
	String et2;

	String name,address,landmark;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		List<String> list=new ArrayList<String>();
		list.add(" Ist   ");
		list.add(" IInd  ");
		list.add(" IIIrd ");
		list.add(" IVth  ");
		list.add(" Vth   ");
		list.add(" VIth  ");
		list.add(" VIIth ");
		list.add(" VIIIth");
		list.add("GUEST");
		list.add("Professor");
		list.add("GNDU EMPLOYEE");
		list.add("GNDU OTHER EMPLOYEE");
		ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
		adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auth);	
		bt=(Button) findViewById(R.id.minfo);
		bt1=(Button) findViewById(R.id.button2);
		et=(EditText)findViewById(R.id.editText1);

		((Spinner)findViewById(R.id.spinner)).setAdapter(adp);

		((Spinner)findViewById(R.id.spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				et2=parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		bt.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				
				if(et.getText().toString().equals(""))
				{
					Toast.makeText(Auth.this,"Please fill the Information!!!!",Toast.LENGTH_LONG).show();
					Toast.makeText(Auth.this,"All Fileds are Required!!!!",Toast.LENGTH_LONG).show();
				}
				else
				{
				SQLiteDatabase bd=openOrCreateDatabase("gndu",MODE_PRIVATE, null);
				bd.execSQL("CREATE TABLE  IF NOT EXISTS stu_info(name VARCHAR,semester VARCHAR)");
				bd.execSQL("INSERT INTO  stu_info VALUES('"+et.getText().toString().trim()+"','"+et2.toString().trim()+"')");
				bd.close();
				Toast.makeText(Auth.this,"Thanks For Registration",Toast.LENGTH_LONG).show();
				Toast.makeText(Auth.this,"Welcome",Toast.LENGTH_LONG).show();

                    Intent b=new Intent(Auth.this,container.class);

				startActivity(b);
				finish();
				}
			}
		});
                bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				
				finish();
				
			}
	    	});
       try
       {
		SQLiteDatabase bd=openOrCreateDatabase("gndu",MODE_PRIVATE, null);
		Cursor s=bd.rawQuery("SELECT * FROM stu_info",null);
	    s.moveToFirst();
	    bd.close();

           Intent b=new Intent(Auth.this,container.class);
		//b.putExtra("Message","http://www.gndu.ac.in/gndu2014/Gndu_pdf/courses.pdf");
		startActivity(b);
		finish();
       }
       catch(Exception e)
       {
    	   
       }
       
      
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
	
	}

}
