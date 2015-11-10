package br.com.lazaro.trabalho.control;

import br.com.lazaro.trabalho.util.Fisica;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText txtMassa;
	private EditText txtVelocidade;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtMassa = (EditText) findViewById(R.id.main_txt_massa);
        txtVelocidade = (EditText) findViewById(R.id.main_txt_velocidade);
    }
    
    public void calcula(View v) {
    	double massa = Double.parseDouble(txtMassa.getText().toString());
    	double velocidade = Double.parseDouble(txtVelocidade.getText().toString());
    	Toast t = Toast.makeText(this, "Força = " + Fisica.calculaForca(massa, velocidade) + " J" , Toast.LENGTH_LONG);
    	t.show();
    }

}
