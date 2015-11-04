package br.com.lazaro.trabalho.control;

import br.com.lazaro.util.Matematica;
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
        
        txtNumero = (EditText) findViewById(R.id.fatorial_txt_numero);
    }
    
    public void calculaFatorial(View v) {
    	long numero = Long.parseLong(txtNumero.getText().toString());
    	Toast t = Toast.makeText(this, "Fatorial = " + Matematica.calculaFatorial(numero), Toast.LENGTH_SHORT);
    	t.show();
    }

}
