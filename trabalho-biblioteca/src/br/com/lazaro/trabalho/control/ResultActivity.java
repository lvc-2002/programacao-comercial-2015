package br.com.lazaro.trabalho.control;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	private TextView lblNomeLivro;
	private TextView lblNomeAutor;
	private TextView lblAnoPublicacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		lblNomeLivro = (TextView) findViewById(R.id.lbl_nome_do_livro);
		lblNomeAutor = (TextView) findViewById(R.id.lbl_nome_do_autor);
		lblAnoPublicacao = (TextView) findViewById(R.id.lbl_ano_publicacao);
		
		Bundle extra = getIntent().getExtras();
		
		String nomeLivro = extra.getString("nomeLivro");
		String nomeAutor = extra.getString("nomeAutor");
		int anoPublicacao = extra.getInt("anoPublicacao");
		
		lblNomeLivro.setText("Livro: " + nomeLivro);
		lblNomeAutor.setText("Autor: " + nomeAutor);
		lblAnoPublicacao.setText("Ano: " + anoPublicacao);
	}
	
}
