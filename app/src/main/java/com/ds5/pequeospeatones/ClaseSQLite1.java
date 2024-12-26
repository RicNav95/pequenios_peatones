package com.ds5.pequeospeatones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClaseSQLite1 extends SQLiteOpenHelper {
    public static final String Database="Datos_Generales.db";
    public static final int dbversion=1;

    public ClaseSQLite1(Context context,String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,Database,factory,dbversion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Preguntas (_id INTEGER PRIMARY KEY AUTOINCREMENT,Pregunta TEXT,Apartado TEXT,Tipo TEXT,Alternativa_1 TEXT,Alternativa_2 TEXT,Alternativa_3 TEXT,Alternativa_4 TEXT,Correcta INTEGER,Imagen TEXT);");
        db.execSQL("Create table Puntuaciones(_id INTEGER PRIMARY KEY AUTOINCREMENT,Nombre TEXT,Puntuacion INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Preguntas;");
        db.execSQL("DROP TABLE IF EXISTS Puntuaciones;");
        onCreate(db);
}
}



