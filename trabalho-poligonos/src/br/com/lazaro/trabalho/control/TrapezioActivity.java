package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.lazaro.trabalho.model.Trapezio;
import br.com.lazaro.trabalho.util.Poligonos;

public class TrapezioActivity extends Activity {
	
	private EditText txtBaseMenor;
	private EditText txtBaseMaior;
	private EditText txtAltura;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trapezio);
		
		txtBaseMenor = (EditText) findViewById(R.id.trapezio_txt_base_menor);
		txtBaseMaior = (EditText) findViewById(R.id.trapezio_txt_base_maior);
		txtAltura = (EditText) findViewById(R.id.trapezio_txt_altura);
	}
	
	public void calcula(View v) {
		double baseMenor = Double.parseDouble(txtBaseMenor.getText().toString());
		double baseMaior = Double.parseDouble(txtBaseMaior.getText().toString());
		double altura = Double.parseDouble(txtAltura.getText().toString());
		Toast t = Toast.makeText(this, "Área = " + Poligonos.calculaArea(new Trapezio(baseMenor, baseMaior, altura)), Toast.LENGTH_SHORT);
		t.show();
	}

}
