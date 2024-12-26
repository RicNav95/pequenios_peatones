package com.ds5.pequeospeatones;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;


public class Fallo_Puente extends AppCompatActivity {
    public Button btn1, btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_fallo_puente);
        btn1 = findViewById(R.id.button6);
        btn2 = findViewById(R.id.button7);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fallo_Puente.this, Pantalla_Paso_peatonal.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fallo_Puente.this, Pagina_Principal.class);
                startActivity(i);
            }
        });

    }
}
