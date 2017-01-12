package com.hari.lovelywedding.lovelywedding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gallery extends AppCompatActivity {


    Button offc,shar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        offc = (Button)findViewById(R.id.offc);

        shar = (Button)findViewById(R.id.shar);

        offc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gallery.this, Webview.class);
                intent.putExtra("data", "https://drive.google.com/open?id=0B1VA3myVb1gNWktuSTg2VDJ3UkE");
                startActivity(intent);
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B1VA3myVb1gNWktuSTg2VDJ3UkE")));
            }
        });

        shar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(gallery.this, Webview.class);
                intent.putExtra("data", "https://drive.google.com/open?id=0B1VA3myVb1gNWHFQN2w0WXZra3M");
                startActivity(intent);
 //               startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B1VA3myVb1gNWHFQN2w0WXZra3M")));
            }
        });
    }
}
