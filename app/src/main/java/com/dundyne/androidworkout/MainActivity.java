package com.dundyne.androidworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    public int counter;
    Button button;
    TextView textView;
    VideoView vid;
    MediaController m;
    public static final String EXTRA_MESSAGE =
            "com.dundyne.androidworkout.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void launchSecondActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, "test");
        startActivity(intent);
    }

        public void loginActivity(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void exerciseActivity(View v){
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);
    }

    public void settingsActivity(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void launchGraphActivity(View v){
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "test");
        startActivity(intent);
    }
}