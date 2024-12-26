package com.ds5.pequeospeatones;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla_Semaforo2 extends AppCompatActivity {
    private VideoView videoView;
    public TextView tv1, tv2, tv3;
    public Button btnSalida;
    public ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4;
    private boolean isPlaying = false;
    private int pausePosition = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_semaforo2);
        videoView = findViewById(R.id.videoView);
        imageView1 = findViewById(R.id.imageView23);
        imageView2 = findViewById(R.id.imageView18);
        imageView3 = findViewById(R.id.imageView22);
        imageView4 = findViewById(R.id.imageView19);
        imageView5 = findViewById(R.id.imageView20);
        tv1 = findViewById(R.id.textView16);
        tv2 = findViewById(R.id.textView17);
        tv3 = findViewById(R.id.textView18);
        btnSalida = findViewById(R.id.button2);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.semaforo_carros);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.luz_roja);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.luz_amarilla);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.luz_verde);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
            }
        });

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_semestral;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                } else {
                    videoView.start();
                }
            }
        });
       imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pausePosition = mediaPlayer1.getCurrentPosition();
                    mediaPlayer1.pause();
                    isPlaying = false;

                } else {
                    mediaPlayer1.seekTo(pausePosition);
                    mediaPlayer1.start();
                    isPlaying = true;

                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pausePosition = mediaPlayer2.getCurrentPosition();
                    mediaPlayer2.pause();
                    isPlaying = false;

                } else {
                    mediaPlayer2.seekTo(pausePosition);
                    mediaPlayer2.start();
                    isPlaying = true;

                }
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pausePosition = mediaPlayer3.getCurrentPosition();
                    mediaPlayer3.pause();
                    isPlaying = false;

                } else {
                    mediaPlayer3.seekTo(pausePosition);
                    mediaPlayer3.start();
                    isPlaying = true;

                }
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pausePosition = mediaPlayer4.getCurrentPosition();
                    mediaPlayer4.pause();
                    isPlaying = false;

                } else {
                    mediaPlayer4.seekTo(pausePosition);
                    mediaPlayer4.start();
                    isPlaying = true;

                }
            }
        });
        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pantalla_Semaforo2.this, Minijuegos.class);
                startActivity(i);
            }
        });

    }


    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer1 != null) {
            if (mediaPlayer1.isPlaying()) {
                mediaPlayer1.stop();
            }
            mediaPlayer1.release();
            mediaPlayer1 = null;
        }
        if (mediaPlayer2 != null) {
            if (mediaPlayer2.isPlaying()) {
                mediaPlayer2.stop();
            }
            mediaPlayer2.release();
            mediaPlayer2 = null;
        }
        if (mediaPlayer3 != null) {
            if (mediaPlayer3.isPlaying()) {
                mediaPlayer3.stop();
            }
            mediaPlayer3.release();
            mediaPlayer3 = null;
        }
        if (mediaPlayer4 != null) {
            if (mediaPlayer4.isPlaying()) {
                mediaPlayer4.stop();
            }
            mediaPlayer4.release();
            mediaPlayer4 = null;
        }
    }
}


