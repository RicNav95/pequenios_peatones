package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pantalla_Senales extends AppCompatActivity {
    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4;
    private ImageView playPauseImage1, playPauseImage2, playPauseImage3, playPauseImage4,imageView1,imageView2,imageView3,imageView4;
    private boolean isPlaying = false;
    private int pausePosition = 0;
    Button btnSalida;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_senales_peatonales);

        playPauseImage1 = findViewById(R.id.imageView48);
        playPauseImage2 = findViewById(R.id.imageView47);
        playPauseImage3 = findViewById(R.id.imageView46);
        playPauseImage4 = findViewById(R.id.imageView45);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.precaucion_senal);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.pasan_autos);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.senal_hombres_trabajando);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.paso_cebra_cerca);

        btnSalida = findViewById(R.id.button5);
        imageView1 = findViewById(R.id.imageView29);
        imageView2 = findViewById(R.id.imageView31);
        imageView3 = findViewById(R.id.imageView33);
        imageView4 = findViewById(R.id.imageView34);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPauseImage1.setVisibility(View.VISIBLE);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPauseImage2.setVisibility(View.VISIBLE);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPauseImage3.setVisibility(View.VISIBLE);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPauseImage4.setVisibility(View.VISIBLE);
            }
        });




        playPauseImage1.setOnClickListener(new View.OnClickListener() {
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
        playPauseImage2.setOnClickListener(new View.OnClickListener() {
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
        playPauseImage3.setOnClickListener(new View.OnClickListener() {
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
        playPauseImage4.setOnClickListener(new View.OnClickListener() {
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
                Intent i = new Intent(Pantalla_Senales.this, Minijuego_Senal.class);
                startActivity(i);
            }
        });

    }

    @Override
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







