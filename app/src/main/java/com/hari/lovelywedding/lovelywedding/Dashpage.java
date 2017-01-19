package com.hari.lovelywedding.lovelywedding;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Dashpage extends AppCompatActivity {

    CarouselView carouselView;
    TextView txt;

    public static TextView tv_countdown;
    int[] sampleImages = {R.drawable.e,R.drawable.f,R.drawable.g, R.drawable.a, R.drawable.b,R.drawable.d};
    Button id,fb,gallery,map,about,upload,setcal,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashpage);
        id= (Button) findViewById(R.id.live);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        tv_countdown = (TextView)findViewById(R.id.textView);
        gallery= (Button) findViewById(R.id.gallery);
        fb= (Button) findViewById(R.id.fb);
        map = (Button)findViewById(R.id.mep);
        about =(Button)findViewById(R.id.about);
        upload =(Button)findViewById(R.id.upload);
        setcal = (Button)findViewById(R.id.setcal);
        share = (Button)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.hari.lovelywedding.lovelywedding");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date futureDate = null;
        try {
            futureDate = dateFormat.parse("2017-02-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getCountdownText(Dashpage.this,futureDate);

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

                    Calendar cal = new GregorianCalendar(2017, 02, 23);
                    cal.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
                    cal.set(Calendar.HOUR, 0);
                    cal.set(Calendar.MINUTE, 0);
                    long start = cal.getTimeInMillis();

                    Calendar endTime = Calendar.getInstance();
                    endTime.set(2017, 2, 23, 8, 45);
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

//                Intent intent = new Intent(Dashpage.this, Webview.class);
//                intent.putExtra("data", "https://www.facebook.com/marriageinheaven");
//                startActivity(intent);
//                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/marriageinheaven")));
                final String urlFb = "fb://page/1660521550628582";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlFb));

                // If a Facebook app is installed, use it. Otherwise, launch
                // a browser
                final PackageManager packageManager = getPackageManager();
                List<ResolveInfo> list =
                        packageManager.queryIntentActivities(intent,
                                PackageManager.MATCH_DEFAULT_ONLY);
                if (list.size() == 0) {
                    final String urlBrowser = "https://www.facebook.com/marriageinheaven";
                    intent.setData(Uri.parse(urlBrowser));
                }

                startActivity(intent);

            }
        });


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  //              Intent intent = new Intent(Dashpage.this, Webview.class);
//                intent.putExtra("data", "https://script.google.com/macros/s/AKfycbxPH0SzouJgg1tb9fb2S1K7Sw6kZTAcJ_p8hiqISlkySCccxHkG/exec");
                String strUri = "https://script.google.com/macros/s/AKfycbxPH0SzouJgg1tb9fb2S1K7Sw6kZTAcJ_p8hiqISlkySCccxHkG/exec";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

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

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    public static CharSequence getCountdownText(Context context, Date futureDate) {
        StringBuilder countdownText = new StringBuilder();

        // Calculate the time between now and the future date.
        long timeRemaining = futureDate.getTime() - new Date().getTime();

        // If there is no time between (ie. the date is now or in the past), do nothing
        if (timeRemaining > 0) {
            Resources resources = context.getResources();

            // Calculate the days/hours/minutes/seconds within the time difference.
            //
            // It's important to subtract the value from the total time remaining after each is calculated.
            // For example, if we didn't do this and the time was 25 hours from now,
            // we would get `1 day, 25 hours`.
            int days = (int) TimeUnit.MILLISECONDS.toDays(timeRemaining);
            timeRemaining -= TimeUnit.DAYS.toMillis(days);
            int hours = (int) TimeUnit.MILLISECONDS.toHours(timeRemaining);
            timeRemaining -= TimeUnit.HOURS.toMillis(hours);
            int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(timeRemaining);
            timeRemaining -= TimeUnit.MINUTES.toMillis(minutes);
            int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(timeRemaining);

            // For each time unit, add the quantity string to the output, with a space.
            if (days > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.days, days, days));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.hours, hours, hours));
                countdownText.append(" ");
            }
            if (days > 0 || hours > 0 || minutes > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.minutes, minutes, minutes));
                countdownText.append(" ");
            }


            String s = countdownText.toString();

            Log.e("timer",s);
            tv_countdown.setText(s);



        }


        return  countdownText.toString();

    }


}
