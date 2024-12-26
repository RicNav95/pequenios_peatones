package com.ds5.pequeospeatones;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantalla_Registro extends AppCompatActivity{
    TextView txt;
    EditText nombre;
    Button btn,btnsiguiente;
    Cursor c;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_registro);
        txt=findViewById(R.id.textView13);
        nombre=findViewById(R.id.editTextText);
        btn=findViewById(R.id.button8);
        btnsiguiente=findViewById(R.id.button9);

        ClaseSQLite1 csql= new ClaseSQLite1(this,"Datos-Generales",null,2);
        final SQLiteDatabase db = csql.getWritableDatabase();
        c=db.rawQuery("SELECT * FROM Puntuaciones",null);
        final ContentValues nuevoRegistro = new ContentValues();
        alert=new AlertDialog.Builder(this);

        Intent i =getIntent();
        int correcta=i.getIntExtra("Correctas",0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoRegistro.put("Nombre",nombre.getText().toString());
                nuevoRegistro.put("Puntuacion",correcta);
                db.insert("Puntuaciones",null,nuevoRegistro);
                Toast.makeText(getApplicationContext(), "Puntuación añadida correctamente", Toast.LENGTH_LONG).show();
                nombre.setText("");
                c = db.rawQuery("select * from Preguntas", null);
            }
        });
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Pantalla_Registro.this, Ranking.class);
                startActivity(intent);
            }
  });
}

}
