package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.lazaro.trabalho.model.Triangulo;
import br.com.lazaro.trabalho.util.Poligonos;

public class TrianguloActivity extends Activity {
	
	private EditText txtBase;
	private EditText txtAltura;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_triangulo);
		
		txtBase = (EditText) findViewById(R.id.triangulo_txt_base);
		txtAltura = (EditText) findViewById(R.id.triangulo_txt_altura);
	}
	
	public void calcula(View v) {
		double base = Double.parseDouble(txtBase.getText().toString());
		double altura = Double.parseDouble(txtAltura.getText().toString());
		Toast t = Toast.makeText(this, "Área = " + Poligonos.calculaArea(new Triangulo(base, altura)), Toast.LENGTH_SHORT);
		t.show();
	}

}
