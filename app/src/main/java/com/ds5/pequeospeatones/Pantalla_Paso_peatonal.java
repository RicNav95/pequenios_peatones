package com.ds5.pequeospeatones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla_Paso_peatonal extends AppCompatActivity {
    private VideoView videoView;
    public Button btnSalida;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_paso_peatonal);
        videoView = findViewById(R.id.videoView3);
        btnSalida = findViewById(R.id.button11);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_puente;
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
        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pantalla_Paso_peatonal.this, MiniJuego_puente.class);
                startActivity(i);
            }
        });

    }
}

