package com.dundyne.androidworkout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import static com.dundyne.androidworkout.YoutubeConfig.*;

//*** Tatt mye kode fra: https://www.youtube.com/watch?v=W4hTJybfU7s
//    Veldig bra video for å vise hvordan man skal bruke youtube android plaer api, samt og skaffe en api fra google console

public class YoutubeActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    Button btnYoutube;
    YouTubePlayer.OnInitializedListener onInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        btnYoutube = (Button) findViewById(R.id.btnYoutube);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("youtubetag", "Youtube video er ferdig lastet inn.");
                youTubePlayer.loadVideo("wWGulLAa0O0");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("youtubefailtag", "Something went wrong..");
            }
        };
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                youtubeView.initialize(getApiKey(), onInitializedListener );
            }
        });


    }
}