package br.edu.ifpi.lazaro.control;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.edu.ifpi.lazaro.adapters.LivroAdapter;
import br.edu.ifpi.lazaro.dao.LivroDAO;
import br.edu.ifpi.lazaro.model.Livro;

public class MainActivity extends Activity {
	
	private ListView listaLivros;
	private List<Livro> livros;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LivroDAO dao = new LivroDAO(this);
        dao.inserir(new Livro("1234", "Teste1", "Teste1", 2015));
        listaLivros();
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	listaLivros();
    }
    
    public void novo(View v) {
    	startActivity(new Intent(this, CadastroLivroActivity.class));
    }
    
    private void listaLivros() {
    	listaLivros = (ListView) findViewById(R.id.main_lista_livros);
    	livros = new LivroDAO(this).listar();
    	if(livros != null) {
    		listaLivros.setAdapter(new LivroAdapter(this, livros));
        	listaLivros.setOnItemClickListener(new PreparaEdicao(this));
    	}
    }
    
    private class PreparaEdicao implements OnItemClickListener {
    	
    	private Context context;
    	
    	public PreparaEdicao(Context context) {
    		this.context = context;
    	}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent i = new Intent(MainActivity.this, CadastroLivroActivity.class);
			i.putExtra("id", livros.get(position).getId());
			context.startActivity(i);
		}

    }

}
