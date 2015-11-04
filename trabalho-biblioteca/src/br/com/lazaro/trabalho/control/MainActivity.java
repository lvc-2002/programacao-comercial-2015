package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText txtNomeLivro;
	private EditText txtNomeAutor;
	private EditText txtAnoPublicacao;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtNomeLivro = (EditText) findViewById(R.id.txt_nome_do_livro);
        txtNomeAutor = (EditText) findViewById(R.id.txt_nome_do_autor);
        txtAnoPublicacao = (EditText) findViewById(R.id.txt_ano_publicacao);
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	
    	txtNomeLivro.setText("");
    	txtNomeAutor.setText("");
    	txtAnoPublicacao.setText("");
    	txtNomeLivro.clearFocus();
    }
    
    public void visualiza(View v) {
    	String nomeLivro = txtNomeLivro.getText().toString();
    	String nomeAutor = txtNomeAutor.getText().toString();
    	int anoPublicacao = Integer.parseInt(txtAnoPublicacao.getText().toString());
    	
    	String ano = anoPublicacao+"";
    	if(nomeLivro != null && !nomeLivro.isEmpty() && nomeAutor != null && !nomeAutor.isEmpty() && ano != null && !ano.isEmpty()) {
    		Intent i = new Intent(this, ResultActivity.class);
        	i.putExtra("nomeLivro", nomeLivro);
        	i.putExtra("nomeAutor", nomeAutor);
        	i.putExtra("anoPublicacao", anoPublicacao);
        	
        	startActivity(i);
    	} else {
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle("Atenção");
    		builder.setMessage("Informe os dados do livro!");
    		
    		AlertDialog ad = builder.create();
    		ad.show();
    	}
    	
    }

}
