package com.dundyne.androidworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity  {
    public int counter;
    Button button;
    TextView textView;
    VideoView vid;
    MediaController m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vid = (VideoView)findViewById(R.id.VideoViewSteroidz);
        button= (Button) findViewById(R.id.BtnTimer);
        textView= (TextView) findViewById(R.id.TimerCountdown);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counter = 60;
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText(String.valueOf(counter));
                        counter--;
                    }
                    public  void onFinish(){
                        textView.setText("FINISH!!");
                    }
                }.start();
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
}