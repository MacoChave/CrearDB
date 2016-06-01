package com.macochave.dbapp;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private EditText txtNombre, txtApellido, txtTelefono;
	private Button guardar, ver, azar;
	private DBManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtNombre = (EditText) findViewById(R.id.edtNombre);
		txtApellido = (EditText) findViewById(R.id.edtApellido);
		txtTelefono = (EditText) findViewById(R.id.edtTelefono);
		guardar = (Button) findViewById(R.id.btnEnviar);
		ver = (Button) findViewById(R.id.btnVer);
		azar = (Button) findViewById(R.id.btnRandom);
		
		guardar.setOnClickListener(this);
		ver.setOnClickListener(this);
		azar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		if(v.getId() == R.id.btnEnviar){
			try {
				long retorno;
				manager = new DBManager(this);
				retorno = manager.insertContacto(txtNombre.getText().toString(), txtApellido.getText().toString(), txtTelefono.getText().toString());
				
				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				
				if(retorno < 1){
					Toast.makeText(getApplicationContext(), "Fallo al ingresar los datos", Toast.LENGTH_SHORT).show();
				} else{
					Toast.makeText(getApplicationContext(), "Ingreso con éxito", Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
		} else if (v.getId() == R.id.btnVer) {
			Intent i = new Intent(MainActivity.this, SecondActivity.class);
			startActivity(i);
		} else if (v.getId() == R.id.btnRandom) {
			Intent i = new Intent();
			startActivity(i);
		}
	}
}
