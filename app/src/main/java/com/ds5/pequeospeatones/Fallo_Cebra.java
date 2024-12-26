package com.ds5.pequeospeatones;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class Fallo_Cebra extends AppCompatActivity {
    public Button btn1, btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_fallo_cebra);
        btn1 = findViewById(R.id.button61);
        btn2 = findViewById(R.id.boton71);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fallo_Cebra.this, Pantalla_paso_Cebra.class);
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fallo_Cebra.this, Pagina_Principal.class);
                startActivity(i);
            }
        });

    }
}
