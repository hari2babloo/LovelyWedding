package com.hari.lovelywedding.lovelywedding;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Dashpage extends AppCompatActivity {

    Button id,fb,gallery,map,about,upload,setcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashpage);
        id= (Button) findViewById(R.id.live);

        gallery= (Button) findViewById(R.id.gallery);
        fb= (Button) findViewById(R.id.fb);
        map = (Button)findViewById(R.id.mep);
        about =(Button)findViewById(R.id.about);
        upload =(Button)findViewById(R.id.upload);
        setcal = (Button)findViewById(R.id.setcal);

        setcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(Dashpage.this, Manifest.permission.WRITE_CALENDAR);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            Dashpage.this,
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            Integer.parseInt("123"));
                } else {

                    Calendar cal = new GregorianCalendar(2017, 11, 14);
                    cal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
                    cal.set(Calendar.HOUR, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    long start = cal.getTimeInMillis();

                    Calendar endTime = Calendar.getInstance();
                    endTime.set(2017, 9, 14, 8, 45);
                        Intent intent = new Intent(Intent.ACTION_INSERT)
                                .setData(CalendarContract.Events.CONTENT_URI)
                                .putExtra(CalendarContract.Events.TITLE, "Danny Wedding")
                                .putExtra(CalendarContract.Events.EVENT_LOCATION, "CSI Church")
                                .putExtra(CalendarContract.Events.ALL_DAY,true)

                               // .putExtra(CalendarContract.Events.DTSTART, "17/07/1991");
                             .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, start);
//                              .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, "2017-07-24 25:000");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }

                }

            }
        });

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashpage.this, Webview.class);
                intent.putExtra("data", "http://lovelyideas.in/danny.html");
                startActivity(intent);
              //  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://lovelyideas.in/danny.html")));
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashpage.this, Webview.class);
                intent.putExtra("data", "https://www.facebook.com/marriageinheaven");
                startActivity(intent);
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/marriageinheaven")));
            }
        });


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashpage.this, Webview.class);
                intent.putExtra("data", "https://script.google.com/macros/s/AKfycbxPH0SzouJgg1tb9fb2S1K7Sw6kZTAcJ_p8hiqISlkySCccxHkG/exec");
                startActivity(intent);

 //               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://script.google.com/macros/s/AKfycbxPH0SzouJgg1tb9fb2S1K7Sw6kZTAcJ_p8hiqISlkySCccxHkG/exec")));
            }
        });


        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Dashpage.this, com.hari.lovelywedding.lovelywedding.gallery.class);

                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String strUri = "http://maps.google.com/maps?q=loc:" + 19.068283 + "," + 79.4911053 + " (" + "Danny Marriage at CSI Church" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);
//                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", "19.068283", "79.4911053", "Danny's Wedding");
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
//                startActivity(intent);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashpage.this, About.class);

                startActivity(intent);

            }
        });

    }
}
