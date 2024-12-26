package com.ds5.pequeospeatones;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Adminitrador extends AppCompatActivity{
    int cambiarid,cambiarc;

    Button atras,adelante,anadir,eliminar,salir;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;
    Cursor c;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_administrador);
        ed1=findViewById(R.id.Pregunta);
        ed2=findViewById(R.id.Apartado);
        ed3=findViewById(R.id.Tipo);
        ed4 = findViewById(R.id.Alt_1);
        ed5 = findViewById(R.id.Alt_2);
        ed6 = findViewById(R.id.Alt_3);
        ed7 = findViewById(R.id.Alt_4);
        ed8 = findViewById(R.id.correcta);
        ed9 = findViewById(R.id.imagen);
        atras = findViewById(R.id.atras);
        adelante = findViewById(R.id.adelante);
        anadir = findViewById(R.id.anadir);
        eliminar = findViewById(R.id.eliminar);
        salir = findViewById(R.id.salir);

        ClaseSQLite1 csql= new ClaseSQLite1(this,"Datos-Generales",null,1);
        final SQLiteDatabase db = csql.getWritableDatabase();
        c=db.rawQuery("SELECT * FROM Preguntas",null);
        final ContentValues nuevoRegistro = new ContentValues();
        alert=new AlertDialog.Builder(this);
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoRegistro.put("Pregunta",ed1.getText().toString());
                nuevoRegistro.put("Apartado",ed2.getText().toString());
                nuevoRegistro.put("Tipo",ed3.getText().toString());
                nuevoRegistro.put("Alternativa_1",ed4.getText().toString());
                nuevoRegistro.put("Alternativa_2",ed5.getText().toString());
                nuevoRegistro.put("Alternativa_3",ed6.getText().toString());
                nuevoRegistro.put("Alternativa_4",ed7.getText().toString());
                nuevoRegistro.put("Correcta",ed8.getText().toString());
                nuevoRegistro.put("Imagen",ed9.getText().toString());
                db.insert("Preguntas",null,nuevoRegistro);
                Toast.makeText(getApplicationContext(), "Pregunta añadida correctamente", Toast.LENGTH_LONG).show();
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");
                ed5.setText("");
                ed6.setText("");
                ed7.setText("");
                ed8.setText("");
                ed9.setText("");
                c = db.rawQuery("select * from Preguntas", null);
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setTitle("Confirmación");
                alert
                        .setMessage("Esta seguro de eliminar la pregunta?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id=String.valueOf(c.getInt(0));
                                db.delete("Preguntas","_id=?",new String[]{id});
                                ed1.setText("");
                                ed2.setText("");
                                ed3.setText("");
                                ed4.setText("");
                                ed5.setText("");
                                ed6.setText("");
                                ed7.setText("");
                                ed8.setText("");
                                ed9.setText("");
                                Context context = getApplicationContext();
                                CharSequence text="Pregunta eliminada";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                c = db.rawQuery("select * from Preguntas", null);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        }).create().show();

            }
        });
        adelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    c.moveToNext();
                    ed1.setText(c.getString(1));
                    ed2.setText(c.getString(2));
                    ed3.setText(c.getString(3));
                    ed4.setText(c.getString(4));
                    ed5.setText(c.getString(5));
                    ed6.setText(c.getString(6));
                    ed7.setText(c.getString(7));
                    ed8.setText(String.valueOf(c.getInt(8)));
                    ed9.setText(c.getString(9));
                }catch (Exception e){
                    c.moveToFirst();
                    ed1.setText(c.getString(1));
                    ed2.setText(c.getString(2));
                    ed3.setText(c.getString(3));
                    ed4.setText(c.getString(4));
                    ed5.setText(c.getString(5));
                    ed6.setText(c.getString(6));
                    ed7.setText(c.getString(7));
                    ed8.setText(String.valueOf(c.getInt(8)));
                    ed9.setText(c.getString(9));
                }
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    c.moveToPrevious();
                    ed1.setText(c.getString(1));
                    ed2.setText(c.getString(2));
                    ed3.setText(c.getString(3));
                    ed4.setText(c.getString(4));
                    ed5.setText(c.getString(5));
                    ed6.setText(c.getString(6));
                    ed7.setText(c.getString(7));
                    ed8.setText(String.valueOf(c.getInt(8)));
                    ed9.setText(c.getString(9));
                }catch (Exception e){
                    c.moveToLast();
                    ed1.setText(c.getString(1));
                    ed2.setText(c.getString(2));
                    ed3.setText(c.getString(3));
                    ed4.setText(c.getString(4));
                    ed5.setText(c.getString(5));
                    ed6.setText(c.getString(6));
                    ed7.setText(c.getString(7));
                    ed8.setText(String.valueOf(c.getInt(8)));
                    ed9.setText(c.getString(9));
                }
            }
        });
        salir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(Adminitrador.this, Pagina_Principal.class);
                startActivity(i);
            }
            });
    }


}
