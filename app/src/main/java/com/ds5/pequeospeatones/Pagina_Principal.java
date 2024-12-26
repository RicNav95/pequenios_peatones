package com.ds5.pequeospeatones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Pagina_Principal extends AppCompatActivity {
    private ImageView boton1, boton2, boton3, boton4, boton5, boton6, botonWeb;
    private TextView txt,txtdesbloqueable;
    private int llave;
    private int necesarias=4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_lecciones);
        boton1 = findViewById(R.id.imageView6);
        boton2 = findViewById(R.id.imageView8);
        boton3 = findViewById(R.id.imageView9);
        boton4 = findViewById(R.id.imageView10);
        boton5 = findViewById(R.id.imageView12);
        boton6 = findViewById(R.id.imageView4);
        botonWeb = findViewById(R.id.imageView7);
        txt = findViewById(R.id.textView);
        txtdesbloqueable = findViewById(R.id.txtdesbloqueable);
        SharedPreferences sharedPref = getSharedPreferences("Cartel", Context.MODE_PRIVATE);
        llave = sharedPref.getInt("llaves", 0);
        txt.setText("Llaves: " + llave);


        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, pantalla_semaforo1.class);
                startActivity(i);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, Pantalla_Paso_peatonal.class);
                startActivity(i);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, Pantalla_paso_Cebra.class);
                startActivity(i);
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, Pantalla_Senales.class);
                startActivity(i);
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, Pantalla_Final.class);
                startActivity(i);
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pagina_Principal.this, Adminitrador.class);
                startActivity(i);
            }
        });
        botonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                // Iniciar el intent
                startActivity(browserIntent);
            }
         });


    }


    protected void onResume() {
        super.onResume();
        // Actualizar el valor de llaves cuando se vuelve a la actividad principal
        SharedPreferences sharedPref = getSharedPreferences("Cartel", Context.MODE_PRIVATE);
        llave = sharedPref.getInt("llaves", 0);
        txt.setText("Llaves: " + llave);
    }
    private void actualizar_botones() {
        if (llave >= necesarias) {
            boton5.setEnabled(true);
            txtdesbloqueable.setText("¡Puedes desbloquear!");
        } else {
            boton5.setEnabled(false);
            txtdesbloqueable.setText("Te faltan " + (necesarias - llave) + " llaves");
        }
    }
}
