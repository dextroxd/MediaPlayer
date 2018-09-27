package com.dextroxd.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
        Button button = findViewById(R.id.button_play);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying()!=true)
                    mediaPlayer.start();

            }
        });
        Button buttonpa = findViewById(R.id.button_pause);
        buttonpa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying()==true)
                    mediaPlayer.pause();

            }
        });
        Button binc = findViewById(R.id.inc);
        binc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying()==true)
                {

                    int a =mediaPlayer.getCurrentPosition();
                    mediaPlayer.seekTo(a+10000);

                }

            }
        });

    }
}
