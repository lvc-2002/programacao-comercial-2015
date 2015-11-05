package br.com.lazaro.trabalho.control;

import br.com.lazaro.trabalho.util.Matematica;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText txtA1;
	private EditText txtQ;
	private EditText txtN;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtA1 = (EditText) findViewById(R.id.pg_txt_a1);
        txtQ = (EditText) findViewById(R.id.pg_txt_q);
        txtN = (EditText) findViewById(R.id.pg_txt_n);
    }
    
    public void calcula(View v) {
    	int a1 = Integer.parseInt(txtA1.getText().toString());
    	int q = Integer.parseInt(txtQ.getText().toString());
    	int n = Integer.parseInt(txtN.getText().toString());
    	
    	Toast t = Toast.makeText(this, "An = " + Matematica.calculaAnPG(a1, q, n), Toast.LENGTH_LONG);
    	t.show();
    }

}
