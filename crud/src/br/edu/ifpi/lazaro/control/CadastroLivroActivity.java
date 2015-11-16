package br.edu.ifpi.lazaro.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.edu.ifpi.lazaro.dao.LivroDAO;
import br.edu.ifpi.lazaro.model.Livro;

public class CadastroLivroActivity extends Activity {
	
	private EditText txtIsbn;
	private EditText txtTitulo;
	private EditText txtAutor;
	private EditText txtAno;
	private Button btnExcluir;
	private Bundle extras;
	private Livro livro;
	private LivroDAO dao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_livro);
		
		txtIsbn = (EditText) findViewById(R.id.cadastro_livro_txt_isbn);
		txtTitulo = (EditText) findViewById(R.id.cadastro_livro_txt_titulo);
		txtAutor = (EditText) findViewById(R.id.cadastro_livro_txt_autor);
		txtAno = (EditText) findViewById(R.id.cadastro_livro_txt_ano);
		btnExcluir = (Button) findViewById(R.id.cadastro_livro_btn_excluir);
		
		extras = getIntent().getExtras();
		
		dao = new LivroDAO(this);
		
		if(extras != null) {
			long id = extras.getLong("id");
			LivroDAO dao = new LivroDAO(this);
			livro = dao.consultar(id);
			txtIsbn.setText(livro.getIsbn());
			txtTitulo.setText(livro.getTitulo());
			txtAutor.setText(livro.getAutor());
			txtAno.setText(livro.getAno()+"");
			btnExcluir.setVisibility(View.VISIBLE);
		}
		
	}
	
	public void salva(View v) {
		String isbn = txtIsbn.getText().toString();
		String titulo = txtTitulo.getText().toString();
		String autor = txtAutor.getText().toString();
		int ano = Integer.parseInt(txtAno.getText().toString());
		
		LivroDAO dao = new LivroDAO(this);
		
		if(extras == null) {
			livro = new Livro(isbn, titulo, autor, ano);
			dao.inserir(livro);
		} else {
			livro.setIsbn(isbn);
			livro.setTitulo(titulo);
			livro.setAutor(autor);
			livro.setAno(ano);
			dao.atualiza(livro);
		}
		
		Toast t = Toast.makeText(this, "Livro salvo!", Toast.LENGTH_LONG);
		t.show();
		finish();
	}
	
	public void exclui(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Atenção!");
		builder.setMessage("Tem certeza de que deseja excluir " + livro.getTitulo() + " ?");
		builder.setPositiveButton("Sim", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dao.deletar(livro);
				Toast t = Toast.makeText(CadastroLivroActivity.this, "Livro excluído!", Toast.LENGTH_LONG);
				t.show();
				finish();
			}
		});
		builder.setNegativeButton("Não", null);
		AlertDialog ad = builder.create();
		ad.show();
	}

}
