package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;

public class Minijuego_Senal extends AppCompatActivity {
    private int pregunta_actual = 0;
    private int respuestas_correctas = 0;
    private int respuestas_incorrectas = 0;
    int respuesta;
    String ruta_imagen;

    TextView Preguntas, Correctas, Incorrectas;
    Button rb5, rb6, rb7, rb8;

    ImageView imagenes;

    Cursor cursorpreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_minijuego_semaforo);

        Preguntas = findViewById(R.id.textView6);
        rb5 = findViewById(R.id.option1Button);
        rb6 = findViewById(R.id.option2Button);
        rb7 = findViewById(R.id.option3Button);
        rb8 = findViewById(R.id.option4Button);
        Correctas = findViewById(R.id.textView8);
        Incorrectas = findViewById(R.id.textView7);
        imagenes = findViewById(R.id.imageView26);

        ClaseSQLite1 clase = new ClaseSQLite1(this, "Datos-Generales", null, 1);
        SQLiteDatabase db = clase.getReadableDatabase();
        cursorpreguntas = db.rawQuery("SELECT * FROM Preguntas WHERE Apartado='Señales Peatonales'", null);

        mostrar_preguntas();
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuesta = 1;
                verificar_pregunta(respuesta);
            }
        });
        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuesta = 2;
                verificar_pregunta(respuesta);
            }
        });
        rb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuesta = 3;
                verificar_pregunta(respuesta);
            }
        });
        rb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuesta = 4;
                verificar_pregunta(respuesta);
            }
        });

    }

    @SuppressLint("Range")
    private void mostrar_preguntas() {
        if (cursorpreguntas.moveToPosition(pregunta_actual)) {
            Preguntas.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Pregunta")));
            String Tipo = cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Tipo"));
            String rutaimagen = cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Imagen"));
            if (rutaimagen != null && !rutaimagen.isEmpty()) {
                int drawableId = getResources().getIdentifier(rutaimagen, "drawable", getPackageName());
                if (drawableId != 0) {
                    imagenes.setImageDrawable(ContextCompat.getDrawable(this, drawableId));
                    imagenes.setVisibility(View.VISIBLE);
                } else {
                    imagenes.setVisibility(View.INVISIBLE);
                }
            } else {
                imagenes.setVisibility(View.INVISIBLE);
            }

            if (Tipo.equals("selección multiple")) {
                rb5.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_1")));
                rb6.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_2")));
                rb7.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_3")));
                rb8.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_4")));

                rb7.setVisibility(View.VISIBLE);
                rb8.setVisibility(View.VISIBLE);
            } else if (Tipo.equals("cierto y falso")) {
                rb5.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_1")));
                rb6.setText(cursorpreguntas.getString(cursorpreguntas.getColumnIndex("Alternativa_2")));

                rb7.setVisibility(View.INVISIBLE);
                rb8.setVisibility(View.INVISIBLE);
            }
        } else {
            if (respuestas_correctas > respuestas_incorrectas) {
                Intent i = new Intent(Minijuego_Senal.this, Recompensa.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(Minijuego_Senal.this,Fallo_senal.class);
                startActivity(i);
                finish();
            }

        }
    }

    private void verificar_pregunta(int respuesta) {
        @SuppressLint("Range") int correcta = cursorpreguntas.getInt(cursorpreguntas.getColumnIndex("Correcta"));
        if (respuesta == correcta) {
            respuestas_correctas++;
        } else {
            respuestas_incorrectas++;
        }

        actualizar_puntuacion();
        pregunta_actual++;
        mostrar_preguntas();
    }


    private void actualizar_puntuacion() {
        Correctas.setText("Correctas: " + respuestas_correctas);
        Incorrectas.setText("Incorrectas: " + respuestas_incorrectas);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursorpreguntas != null && !cursorpreguntas.isClosed()) {
            cursorpreguntas.close();

        }
    }

}
