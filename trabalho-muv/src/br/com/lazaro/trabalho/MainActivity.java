package br.com.lazaro.trabalho;

import br.com.lazaro.trabalho.util.Fisica;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText txtVelocidadeInicial;
	private EditText txtDeslocamento;
	private EditText txtAceleracao;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtVelocidadeInicial = (EditText) findViewById(R.id.muv_velocidade_inicial);
        txtDeslocamento = (EditText) findViewById(R.id.muv_deslocamento_total);
        txtAceleracao = (EditText) findViewById(R.id.muv_aceleracao);
    }
    
    public void calcula(View v) {
    	double velocidadeInicial = Double.parseDouble(txtVelocidadeInicial.getText().toString());
    	double deslocamento = Double.parseDouble(txtDeslocamento.getText().toString());
    	double aceleracao = Double.parseDouble(txtAceleracao.getText().toString());
    	
    	Toast t = Toast.makeText(this, "Velocidade Final = " + Fisica.velocidadeFinal(velocidadeInicial, deslocamento, aceleracao), Toast.LENGTH_LONG);
    	t.show();
    }

}
