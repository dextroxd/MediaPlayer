package com.dextroxd.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song);
        Button button = findViewById(R.id.button_play);
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v)
            {
                if(!mediaPlayer.isPlaying())
                {       mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {

                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                                mediaPlayer = null;
                            }
                        }

                    });
                }
                else
                {
                    mediaPlayer.pause();
                }


            }
        });
        Button buttonpa = findViewById(R.id.button_pause);
        buttonpa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.pause();

            }
        });
        Button binc = findViewById(R.id.inc);
        binc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying())
                {

                    int a =mediaPlayer.getCurrentPosition();
                    mediaPlayer.seekTo(a+10000);

                }

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
            
        }
    }
}
