package com.gndu.gurunanakdevuniversity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class container extends Activity {
    int pagecount = 3;            //---imp for view no of total page
    LayoutInflater inflater;    //--imp for view Used to create individual pages
    ViewPager vp;                //---imp for view Reference to class to swipe views
    container m;

    //------------first
    Timer timer;
    TimerTask task;
    TextView slidetxt;
    int currentimageindex=1;
    ImageView slidingimage;

    int[] IMAGE_IDS = {
            R.drawable.gndub,R.drawable.lib,R.drawable.rooms,R.drawable.gndue,R.drawable.gndud,R.drawable.hostel,R.drawable.rcjal,R.drawable.hostels,R.drawable.rcjalss,R.drawable.gur,R.drawable.sah,R.drawable.lodh
    };

    ImageView iv18;

    //-----------end first
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vp = (ViewPager) findViewById(R.id.viewPager);
        vp.setAdapter(new MyPagesAdapter());
        vp.setCurrentItem(1);
//------ Set fonts

        String font = "fonts/Roboto-Light.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), font);
        ((TextView) findViewById(R.id.cname)).setTypeface(tf);
        //----End Set Font
//---------------- taker name
        SQLiteDatabase bd = openOrCreateDatabase("gndu", MODE_PRIVATE, null);
        Cursor s = bd.rawQuery("SELECT * FROM stu_info", null);
        s.moveToFirst();
        ((TextView) findViewById(R.id.cname)).setText("Hi! " + s.getString(s.getColumnIndex("name")).toUpperCase());
        bd.close();
        //-------- To Slide menu user

        ((ImageView) findViewById(R.id.midimage)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent b = new Intent(container.this, SlideMenu.class);
                b.putExtra("Message", ((TextView) findViewById(R.id.cname)).getText().toString());
                startActivity(b);

            }
        });
        ((ImageView) findViewById(R.id.imageView18)).setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {

               Intent b = new Intent(container.this, SlideMenu.class);
               b.putExtra("Message",((TextView) findViewById(R.id.cname)).getText().toString());
               startActivity(b);

           }
       });
//--end takler name
//---visit share
        //-------------------------------Header Button Right

       //visit
        ((ImageView) findViewById(R.id.imageView17)).setOnClickListener(new OnClickListener() {

           @Override
           public void onClick(View v) {

               Intent b = new Intent(container.this, Contact_web.class);
               b.putExtra("Message", "http://www.gndu.ac.in/");
               startActivity(b);
           }
       });

        iv18 = (ImageView) findViewById(R.id.imageView2);//share
        registerForContextMenu(iv18);
        iv18.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                openContextMenu(iv18);
            }
        });
// end right end
// -------end vist share

        //-timer init
        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow();


            }
        };

        int delay = 2000; // delay for 1 sec.

        int period = 10000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);


            }

        }, delay, period);
//--------------------------------galery end



    }

    public void AnimateandSlideShow() {


        slidingimage = (ImageView)findViewById(R.id.imageView3);
        slidetxt=(TextView)findViewById(R.id.slidetxt);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
        Animation rotateimage=null;
        rotateimage = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        if(currentimageindex==1)
        {
            slidetxt.setText("Bhai Gurudas ji Library");
        }
        if(currentimageindex==2)
        {
            slidetxt.setText("GNDU AWESOME STUDY ROOMS & FACULTY");
        }
        if(currentimageindex==3)
        {
            slidetxt.setText("Maharaja Ranjit Singh Bhawan");
        }
        if(currentimageindex==4)
        {
            slidetxt.setText("GNDU Department of Law");
        }
        if(currentimageindex==5)
        {
            slidetxt.setText("GNDU HOSTEL(ASR.)");
        }
        if(currentimageindex==6)
        {
            rotateimage=AnimationUtils.loadAnimation(this,R.anim.custom_anim);
            slidetxt.setText("GNDU RC JALANDHAR");

        }
        if(currentimageindex==7)
        {
            slidetxt.setText("GNDU GIRLS HOSTEL (RC JAL.) ");
        }
        if(currentimageindex==8)
        {
            slidetxt.setText("");
        }
        if(currentimageindex==9)
        {
            slidetxt.setText("GNDU RC GURDASPUR");
        }
        if(currentimageindex==10)
        {
            slidetxt.setText("GNDU RC SATHIALA");
        }
        if(currentimageindex==11)
        {
            slidetxt.setText("GNDU RC SULTANPUR LODHI");
        }
        if(currentimageindex==12)
        {
            currentimageindex=0;
            slidetxt.setText("GNDU AMRITSAR CAMPUS");

        }

        currentimageindex++;
        slidingimage.startAnimation(rotateimage);
        slidetxt.startAnimation(rotateimage);
    }



















    class MyPagesAdapter extends PagerAdapter
    {
        @Override
        public int getCount() {

            return pagecount;

        }

        //Create the given page (indicated by position)
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = null;
            if (position == 0)
            {
                page = inflater.inflate(R.layout.swipemenu, null);

//     menu upper



                ((ImageView)page.findViewById(R.id.imageView20)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Admission.class);
                        startActivity(b);


                    }
                });


                ((ImageView)page.findViewById(R.id.imageView21)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Contact_web.class);
                        b.putExtra("Message", "http://www.gndu.ac.in/gndu2014/Gndu_pdf");
                        startActivity(b);

                    }
                });


                ((ImageView)page.findViewById(R.id.imageView23)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        Intent b = new Intent(container.this, Contact_web.class);
                        b.putExtra("Message", "http://www.gndu.ac.in");
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView24)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Campuses.class);
                        startActivity(b);
                    }
                });


                ((ImageView)page.findViewById(R.id.imageView22)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, About_Hostels.class);
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView25)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(container.this, Infrastracture.class));
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView26)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent b = new Intent(container.this, Contact_web.class);
                        b.putExtra("Message", "http://gndu.ac.in/gndu2014/FetchFacultyList.asp");
                        startActivity(b);
                    }
                });


                ((ImageView)page.findViewById(R.id.imageView27)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent b2 = new Intent(container.this, Contact_web.class);
                        b2.putExtra("Message", "http://www.gndu.ac.in/gndu2014/placements.html");
                        startActivity(b2);

                    }
                });

                ((ImageView)page.findViewById(R.id.imageView29)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(container.this, Syllabus.class));
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView30)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(container.this, Contact.class));
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView31)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent b1 = new Intent(container.this, Contact_web.class);
                        b1.putExtra("Message", "http://gndu.ac.in/pdf_files/scholarships.pdf");
                        startActivity(b1);
                    }
                });

                ((ImageView)page.findViewById(R.id.imageView28)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(container.this, History.class));
                    }
                });



                ((ViewPager) container).addView(page, 0);

 }



            if (position ==1)
            {

                page = inflater.inflate(R.layout.activity_main, null);
                String font = "fonts/Roboto-Light.ttf";
                Typeface tf = Typeface.createFromAsset(getAssets(), font);
                ((TextView)page.findViewById(R.id.slidetxt)).setTypeface(tf);
                ((Button)page.findViewById(R.id.minfo)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {

                        startActivity(new Intent(container.this, Message_Of_Vc.class));

                    }
                });
                ((ViewPager) container).addView(page, 0);

            }



            if (position == 2)
            {

                page = inflater.inflate(R.layout.gallery, null);


                ((ImageView)page.findViewById(R.id.s2)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Pic.class);
                        b.putExtra("Src", "5");
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.s3)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Pic.class);
                        b.putExtra("Src", "4");
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.s4)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Pic.class);
                        b.putExtra("Src", "3");
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.s5)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Pic.class);
                        b.putExtra("Src", "2");
                        startActivity(b);
                    }
                });

                ((ImageView)page.findViewById(R.id.s6)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent b = new Intent(container.this, Pic.class);
                        b.putExtra("Src", "1");
                        startActivity(b);
                    }
                });
//  bottom gallery end


                ((ViewPager) container).addView(page, 0);

}

        return page;
}

        @Override
        public boolean isViewFromObject(View arg0, Object arg1)
        {
            return arg0 == (View) arg1;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ((ViewPager) container).removeView((View) object);
            object = null;
        }






    }








    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }













    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == R.id.Exit) {

            System.exit(0);
            return true;
        }
        if (item.getItemId() == R.id.DevelopedBy) {
            startActivity(new Intent(container.this, Developed.class));
            return true;
        }
        else
        {

            return super.onContextItemSelected(item);
        }
    }
}