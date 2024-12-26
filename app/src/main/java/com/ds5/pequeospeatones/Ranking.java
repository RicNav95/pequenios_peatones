package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Ranking extends AppCompatActivity {
    TextView txtmostrar;
    Button btn;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_ranking);
        txtmostrar = findViewById(R.id.top1);
        btn = findViewById(R.id.button10);

        ClaseSQLite1 csql = new ClaseSQLite1(this, "Datos-Generales", null, 2);
        final SQLiteDatabase db = csql.getWritableDatabase();
        c = db.rawQuery("SELECT * FROM Puntuaciones", null);

        mostrar_puntuacion();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Cartel", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    private void mostrar_puntuacion() {
        StringBuilder puntuaciones = new StringBuilder();

        // Mueve el cursor al primer registro
        if (c.moveToFirst()) {
            do {
                // Obtiene los datos de cada columna
                String nombre = c.getString(1);
                int puntuacion = c.getInt(2);

                // Agrega los datos al StringBuilder
                puntuaciones.append("Nombre: ").append(nombre).append(" - Puntuación: ").append(puntuacion).append("\n\n");
            } while (c.moveToNext()); // Mueve el cursor al siguiente registro
        } else {
            puntuaciones.append("No hay puntuaciones disponibles.");
        }

        // Establece el texto del TextView con los datos de puntuación
        txtmostrar.setText(puntuaciones.toString());

    }
}
