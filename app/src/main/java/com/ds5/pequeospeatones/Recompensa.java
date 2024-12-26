package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Recompensa extends AppCompatActivity {
    ImageView imagen;
    TextView recompensas;
    int r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_recompensa);
        recompensas=findViewById(R.id.textView);
        imagen=findViewById(R.id.imageView25);

        SharedPreferences sharedPref = getSharedPreferences("Cartel", Context.MODE_PRIVATE);
        r = sharedPref.getInt("llaves", 0);

        recompensas.setText("Llaves: " + r);


        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.setVisibility(View.INVISIBLE);
                r+=1;
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("llaves", r);
                editor.apply();

                // Actualizar la UI con el nuevo valor
                recompensas.setText("Llaves: " + r);

                Intent i=new Intent(Recompensa.this,Pagina_Principal.class);
                startActivity(i);
            }
        });





    }
}


