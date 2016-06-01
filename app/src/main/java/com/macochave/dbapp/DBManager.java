package com.macochave.dbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

	public static final String TABLA = "contacto";
	public static final String ID = "_id";
	public static final String NOMBRE = "nombre";
	public static final String APELLIDO = "apellido";
	public static final String TELEFONO = "telefono";
	
	public static final String CREATE_TABLE = "CREATE  TABLE  IF NOT EXISTS " + TABLA + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , " + NOMBRE + " TEXT NOT NULL , " + APELLIDO + " TEXT NOT NULL , " + TELEFONO + " TEXT NOT NULL )";
	private DBHelper helper;
	private SQLiteDatabase db;
	/**
	 * 
	 */
	public DBManager(Context context) {
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public ContentValues contenedorValores(String nombre, String apellido, String telefono){
		ContentValues valores = new ContentValues();
		valores.put(NOMBRE, nombre);
		valores.put(APELLIDO, apellido);
		valores.put(TELEFONO, telefono);
		
		return valores;
	}
	
	public long insertContacto(String nombre, String apellido, String telefono){
		return db.insert(TABLA, APELLIDO, contenedorValores(nombre, nombre, telefono));
	}
		
	public Cursor cursorContactos(){
//		String[] columnas = new String[]{"rowid _id", NOMBRE, APELLIDO, TELEFONO};
//		return db.query(TABLA, columnas, null, null, null, null, null);
		return db.rawQuery("SELECT " + ID + " as _id, nombre, telefono FROM contacto " , null);
	}
}
