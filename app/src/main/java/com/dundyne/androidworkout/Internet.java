package com.dundyne.androidworkout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.icu.util.Calendar;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Internet extends AppCompatActivity {



//det fungerer week er ukenr på dato


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        Button btnKalender = (Button)findViewById(R.id.btnKalender);
        //myWebView.loadUrl("https://www.matprat.no/oppskrifter/familien/p/pytt-i-panne-med-lammeskav/");




        btnKalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar instance = Calendar.getInstance();
                int currentDay = instance.get(Calendar.DAY_OF_MONTH);
                int currentMonth = instance.get(Calendar.MONTH);
                int currentYear = instance.get(Calendar.YEAR);
                int month = currentMonth+1;

                int week = instance.get(Calendar.WEEK_OF_YEAR);
                Toast.makeText(getApplicationContext(), "haha" + currentDay + month +  currentYear + week, Toast.LENGTH_SHORT).show();
            }
        });





    }
}
