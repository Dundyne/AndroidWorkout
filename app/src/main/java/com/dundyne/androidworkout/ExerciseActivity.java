package com.dundyne.androidworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.dundyne.androidworkout.dataHandler.TinyDB;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnTimer;
    CountDownTimer countDownTimer;
    TextView textViewTimer;
    TextView textViewStored;
    TextView testView;
    Boolean isRunning = false;
    Integer storeTime;

    TinyDB tinydb;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        tinydb = new TinyDB(getApplicationContext());
        videoView = (VideoView)findViewById(R.id.videoViewExercise);
        btnTimer = findViewById(R.id.btnStart);
        textViewTimer = findViewById(R.id.textViewTimer);
        testView = findViewById(R.id.testView);
        textViewStored = findViewById(R.id.textViewStored);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        countDownTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTimer.setText( "" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                btnTimer.setText("Start");
                storeTime = 60 - Integer.parseInt(textViewTimer.getText().toString());
                textViewStored.setText("You lasted: " + storeTime.toString() + " seconds!");
                textViewTimer.setText("1:00");
                saveToSharedPreferences();

            }
        };

        String path = "android.resource://com.dundyne.androidworkout/"+R.raw.cats;
        Uri u = Uri.parse(path);

        videoView.setVideoURI(u);
        videoView.requestFocus();
        videoView.start();
    }

    public void printProgress(){
        if(!tinydb.getListInt("plank").isEmpty()){
        ArrayList<Integer> progress = tinydb.getListInt("plank");
        testView.setText(progress.toString());
        }
        else {
            testView.setText("empty");
        }
    }

    public void saveToSharedPreferences(){
        if(tinydb.getListInt("plank").isEmpty()){
            ArrayList<Integer> progress = new ArrayList<>();
            progress.add(storeTime);
            tinydb.putListInt("plank", progress);
        }
        else {
            ArrayList<Integer> progress = tinydb.getListInt("plank");
            progress.add(storeTime);
            tinydb.putListInt("plank", progress);
        }
        printProgress();

    }

    public void startStopTimer(View v){

        if(!isRunning){
            countDownTimer.start();
            btnTimer.setText("Stop");
            isRunning = true;
        } else {
            countDownTimer.cancel();
            btnTimer.setText("Start");
            storeTime = 60 - Integer.parseInt(textViewTimer.getText().toString());
            textViewStored.setText("You lasted: " + storeTime.toString() + " seconds!");
            textViewTimer.setText("1:00");
            isRunning = false;
            saveToSharedPreferences();
        }
    }

}