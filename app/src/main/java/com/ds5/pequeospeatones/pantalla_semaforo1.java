package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;
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

public class pantalla_semaforo1 extends AppCompatActivity {
    public Button btnSalida;
    public ImageView imageView1, imageView2, imageView3, imageView4;
    public TextView tv1, tv2;
    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4;
    private boolean isPlaying = false;
    private int pausePosition = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_semaforo);

        imageView1 = findViewById(R.id.imageView5);
        imageView2 = findViewById(R.id.imageView17);
        imageView3 = findViewById(R.id.imageView18);
        imageView4 = findViewById(R.id.imageView16);
        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView4);

        btnSalida = findViewById(R.id.button);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.semaforo_peaton);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.peatones_roja);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.peatones_verde);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView2.setVisibility(View.VISIBLE);
                imageView3.setVisibility(View.VISIBLE);
                imageView4.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
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

        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla_semaforo1.this, Pantalla_Semaforo2.class);
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



    }
}
