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

    //** Stopwatch variables **//
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    //**              **//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vid = (VideoView)findViewById(R.id.VideoViewSteroidz);
        button= (Button) findViewById(R.id.BtnTimer);
        if (savedInstanceState != null) {
            
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();
    }


    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void startTimer(View view){running = true;}
    public void stopTimer(View view){ running = false; }
    public void resetTimer(View view){
        running = false;seconds = 0;
        vid.suspend();
    }

    private void runTimer() {

        final TextView timeView
                = (TextView) findViewById(
                R.id.TimerCountdown);


        final Handler handler
                = new Handler();
        handler.post(new Runnable() {

            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                timeView.setText(time);


                if (running) {
                    seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }

            public void playVideo(View v){
        m = new MediaController(this);
        /*String path = "C:/Users/Henri/Documents/GitHub/AndroidWorkout/funiVideo/catterrrs.mp4";*/
        String path = "android.resource://com.dundyne.androidworkout/"+R.raw.cats;
        Uri u = Uri.parse(path);

        vid.setVideoURI(u);

        vid.start();
    }

        public void launchSecondActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, "test");
        startActivity(intent);
    }

        public void loginActivity(View v){

        Intent intent = new Intent(this, ExerciseActivity.class);

        startActivity(intent);
    }

    public void launchGraphActivity(View v){
        Intent intent = new Intent(this, GraphActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "test");
        startActivity(intent);
    }
}