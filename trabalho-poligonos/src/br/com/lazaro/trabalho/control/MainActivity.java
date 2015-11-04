package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private Spinner cbxPoligono;
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        cbxPoligono = (Spinner) findViewById(R.id.cbx_poligono);
        String[] values = {"Selecione...", "Quadrado", "Retângulo", "Triângulo", "Trapézio"};
        cbxPoligono.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, values));
        
        cbxPoligono.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
				case 0:
					break;
				case 1:
					startActivity(new Intent(MainActivity.this, QuadradoActivity.class));
					break;
				case 2:
					startActivity(new Intent(MainActivity.this, RetanguloActivity.class));
					break;
				case 3:
					startActivity(new Intent(MainActivity.this, TrianguloActivity.class));
					break;
				case 4:
					startActivity(new Intent(MainActivity.this, TrapezioActivity.class));
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
    }

}
