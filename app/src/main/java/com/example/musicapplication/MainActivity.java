package com.example.musicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewPlay, imageViewPause, imageViewStop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPlay = findViewById(R.id.m_play);
        imageViewPause = findViewById(R.id.m_pause);
        imageViewStop = findViewById(R.id.m_stop);

        imageViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });

        imageViewPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();
            }

        });

        imageViewStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
    }

    private void stop() {
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void play() {
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.song2);
        }

        mediaPlayer.start();
    }

    private void pause() {
        if (mediaPlayer != null){
            mediaPlayer.pause();
        }
    }
}