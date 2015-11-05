package br.com.lazaro.trabalho.control;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText txtNumero;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtNumero = (EditText) findViewById(R.id.fibonnaci_numero);
    }
    
    public void calculaFibonnaci(View v) {
    	int ant = 0, fib = 1, n, aux;
    	n = Integer.parseInt(txtNumero.getText().toString());
    	
    	List<Integer> valores = new ArrayList<Integer>();
    	valores.add(ant);
    	for (int i=0; i<n; i++) {
    		valores.add(i + 1 + fib);
    		aux = fib;
    		fib = fib + ant;
    		ant = aux;
    	}
    	
    	Toast t = Toast.makeText(this, valores.toString(), Toast.LENGTH_LONG);
    	t.show();
    }
    
}
