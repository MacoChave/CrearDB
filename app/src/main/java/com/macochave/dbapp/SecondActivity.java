package com.macochave.dbapp;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class SecondActivity extends ActionBarActivity {

	private ListView lista;
	private DBManager manager;
	private Cursor cursor;
	private SimpleCursorAdapter adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		lista = (ListView) findViewById(R.id.lstView);
		
		manager = new DBManager(this);
		cursor = manager.cursorContactos();
		
		String[] de = new String[]{"nombre", "telefono"};
		int[] a = new int[]{android.R.id.text1, android.R.id.text2};
		adaptador  = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, de, a, 0);
		lista.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
