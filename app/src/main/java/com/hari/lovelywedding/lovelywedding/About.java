package com.hari.lovelywedding.lovelywedding;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView dany, jony,dass,rama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        dany = (TextView)findViewById(R.id.dany);

        jony = (TextView)findViewById(R.id.jony);

        dass = (TextView)findViewById(R.id.dass);

        rama = (TextView)findViewById(R.id.rama);

        dany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int permissionCheck = ContextCompat.checkSelfPermission(About.this, Manifest.permission.CALL_PHONE);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            About.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Integer.parseInt("123"));
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:9948844101")));
                }
            }
        });
        jony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "9948844101";

                int permissionCheck = ContextCompat.checkSelfPermission(About.this, Manifest.permission.CALL_PHONE);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            About.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Integer.parseInt("123"));
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:9030266397")));
                }
            }
        });
        dass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "9948844101";
                int permissionCheck = ContextCompat.checkSelfPermission(About.this, Manifest.permission.CALL_PHONE);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            About.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Integer.parseInt("123"));
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:9010891231")));
                }
            }
        });
        rama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "9948844101";
                int permissionCheck = ContextCompat.checkSelfPermission(About.this, Manifest.permission.CALL_PHONE);

                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            About.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Integer.parseInt("123"));
                } else {
                    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:9347578902")));
                }
            }
        });

    }
}
