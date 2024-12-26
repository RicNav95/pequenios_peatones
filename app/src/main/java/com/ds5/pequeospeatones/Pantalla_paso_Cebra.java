package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.*;

public class Pantalla_paso_Cebra extends AppCompatActivity {
    private VideoView videoView;
    public Button btnSalida;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_paso_cebra);
        videoView = findViewById(R.id.videoView2);
        btnSalida = findViewById(R.id.button4);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.paso_de_cebra;
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
                Intent i = new Intent(Pantalla_paso_Cebra.this, Minijuego_cebra.class);
                startActivity(i);
            }
        });

    }

}
