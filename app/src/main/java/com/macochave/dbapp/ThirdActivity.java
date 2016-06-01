package com.macochave.dbapp;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends ActionBarActivity implements OnClickListener{

	private Button btnnuevo;
	private TextView txtElegida;
	private ArrayList<String> arreglo = new ArrayList<>();
	private DBManager manager;
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		btnnuevo = (Button) findViewById(R.id.btnElegir);
		txtElegida = (TextView) findViewById(R.id.txtResultado);
		
		btnnuevo.setOnClickListener(this);
		
//		manager = new DBManager(this);
//		cursor = manager.cursorContactos();
//		adapter = new SimpleCursorAdapter(getApplicationContext(), layout, cursor, from, to)
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
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

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnElegir) {
			try {
				elegirOpcion();
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void elegirOpcion() {
		
	}
}
