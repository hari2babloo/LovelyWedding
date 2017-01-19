package com.hari.lovelywedding.lovelywedding;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Countdown extends AppCompatActivity {

   public static TextView tv_countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);
        tv_countdown = (TextView) findViewById(R.id.textView);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date futureDate = null;
        try {
            futureDate = dateFormat.parse("2017-01-16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        getCountdownText(Countdown.this,futureDate);
    }

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
            if (days > 0 || hours > 0 || minutes > 0 || seconds > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.seconds, seconds, seconds));
                countdownText.append(" ");
            }

            String s = countdownText.toString();

            Log.e("timer",s);
            tv_countdown.setText(s);



        }


        return  countdownText.toString();

    }




}