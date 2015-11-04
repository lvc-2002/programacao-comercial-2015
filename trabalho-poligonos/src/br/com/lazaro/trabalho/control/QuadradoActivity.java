package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.lazaro.trabalho.model.Quadrado;
import br.com.lazaro.trabalho.util.Poligonos;

public class QuadradoActivity extends Activity {
	
	private EditText txtLado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quadrado);
		
		txtLado = (EditText) findViewById(R.id.quadrado_txt_lado);
	}
	
	public void calcula(View v) {
		double lado = Double.parseDouble(txtLado.getText().toString());
		Toast t = Toast.makeText(this, "Área = " + Poligonos.calculaArea(new Quadrado(lado, lado)), Toast.LENGTH_SHORT);
		t.show();
	}
	
}
