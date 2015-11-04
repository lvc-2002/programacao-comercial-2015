package br.com.lazaro.trabalho.util;

import java.text.NumberFormat;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.lazaro.trabalho.control.R;
import br.com.lazaro.trabalho.model.Mercadoria;

public class MercadoriaAdapter extends BaseAdapter {
	
	private Activity activity;
	private List<Mercadoria> mercadorias;
	
	public MercadoriaAdapter(Activity activity, List<Mercadoria> mercadorias) {
		this.activity = activity;
		this.mercadorias = mercadorias;
	}
	
	@Override
	public int getCount() {
		return mercadorias.size();
	}

	@Override
	public Object getItem(int position) {
		return mercadorias.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint({ "ViewHolder", "InflateParams" }) @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = activity.getLayoutInflater().inflate(R.layout.mercadoria, null);
		
		TextView lblDescricao = (TextView) v.findViewById(R.id.mercadoria_descricao);
		TextView lblPreco = (TextView) v.findViewById(R.id.mercadoria_preco);
		
		Mercadoria m = mercadorias.get(position);
		
		lblDescricao.setText(m.getDescricao());
		lblPreco.setText(NumberFormat.getCurrencyInstance().format(m.getPreco()));
		
		return v;
	}

}
