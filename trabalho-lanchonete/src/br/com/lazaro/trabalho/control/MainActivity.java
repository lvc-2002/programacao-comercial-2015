package br.com.lazaro.trabalho.control;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import br.com.lazaro.trabalho.model.Mercadoria;
import br.com.lazaro.trabalho.util.MercadoriaAdapter;

@SuppressLint("InflateParams") public class MainActivity extends Activity {
	
	private ListView listaMercadorias;
	private List<Mercadoria> mercadorias;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listaMercadorias = (ListView) findViewById(R.id.main_lista_mercadorias);
        
        mercadorias = new ArrayList<Mercadoria>();
        mercadorias.add(new Mercadoria("Salgado", 2.5));
        mercadorias.add(new Mercadoria("Suco", 2));
        mercadorias.add(new Mercadoria("Refrigerante", 2));
        mercadorias.add(new Mercadoria("Bolo (Fatia)", 1.5));
        mercadorias.add(new Mercadoria("Café", 0.5));
        mercadorias.add(new Mercadoria("Leite (Copo 200 ml)", 1));
        mercadorias.add(new Mercadoria("Pingado (Copo 200 ml)", 1.2));
        mercadorias.add(new Mercadoria("Cuscuz", 0.8));
        
        listaMercadorias.setAdapter(new MercadoriaAdapter(this, mercadorias));
        
        listaMercadorias.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				View v = getLayoutInflater().inflate(R.layout.dialog, null);
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Quantidade...");
				builder.setMessage("Informe a quantidade de " + mercadorias.get(position).getDescricao() + " que deseja comprar: ");
				builder.setView(v);
				builder.setPositiveButton("Comprar", new CompraMercadoria(v, mercadorias.get(position)));
				AlertDialog ad = builder.create();
				ad.show();
			}
		});
    }
    
    private class CompraMercadoria implements OnClickListener {
    	
    	private View view;
    	private Mercadoria mercadoria;
    	
    	public CompraMercadoria(View view, Mercadoria mercadoria) {
    		this.view = view;
    		this.mercadoria = mercadoria;
    	}
    	
		@Override
		public void onClick(DialogInterface dialog, int which) {
			EditText txtQuantidade = (EditText) view.findViewById(R.id.dialog_txt_quantidade);
			int quantidade = Integer.parseInt(txtQuantidade.getText().toString());
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("Conta");
			builder.setMessage("Mercadoria: " + mercadoria.getDescricao() +
					"\nQuantidade: " + quantidade +
					"\nPreço..........: " + NumberFormat.getCurrencyInstance().format(mercadoria.getPreco()) +
					"\nTotal...........: " + NumberFormat.getCurrencyInstance().format(mercadoria.calculaTotal(quantidade)));
			builder.setPositiveButton("Ok", null);
			AlertDialog ad = builder.create();
			ad.show();
		}
    	
    }

}
