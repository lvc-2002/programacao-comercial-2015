package br.edu.ifpi.lazaro.adapters;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.edu.ifpi.lazaro.control.R;
import br.edu.ifpi.lazaro.model.Livro;

public class LivroAdapter extends BaseAdapter {
	
	private Activity activity;
	private List<Livro> livros;
	
	public LivroAdapter(Activity activity, List<Livro> livros) {
		this.activity = activity;
		this.livros = livros;
	}
	
	@Override
	public int getCount() {
		return livros.size();
	}

	@Override
	public Object getItem(int position) {
		return livros.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint({ "ViewHolder", "InflateParams" }) @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = activity.getLayoutInflater().inflate(R.layout.livro, null);
		Livro livro = livros.get(position);
		TextView lblTitulo = (TextView) v.findViewById(R.id.livro_titulo);
		lblTitulo.setText(livro.getTitulo());
		return v;
	}
	
}
