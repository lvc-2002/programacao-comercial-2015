package br.edu.ifpi.lazaro.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.ifpi.lazaro.model.Livro;
import br.edu.ifpi.lazaro.persistence.DataBase;

public class LivroDAO implements GenericDAO<Livro> {
	
	private Context context;
	
	public LivroDAO(Context context) {
		this.context = context;
	}
	
	@Override
	public void inserir(Livro e) {
		DataBase db = new DataBase(context);
		SQLiteDatabase sdb = db.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("isbn", e.getIsbn());
		values.put("titulo", e.getTitulo());
		values.put("autor", e.getAutor());
		values.put("ano", e.getAno());
		sdb.insert("livros", null, values);
		sdb.close();
	}

	@Override
	public void deletar(Livro e) {
		DataBase db = new DataBase(context);
		SQLiteDatabase sdb = db.getWritableDatabase();
		sdb.delete("livros", "_id = ?", new String[]{e.getId()+""});
		sdb.close();
	}

	@Override
	public Livro consultar(long id) {
		DataBase db = new DataBase(context);
		SQLiteDatabase sdb = db.getReadableDatabase();
		Cursor c = sdb.query("livros", new String[]{"_id", "isbn", "titulo", "autor", "ano"}, "_id = ?", new String[]{id+""}, null, null, null, null);
		c.moveToFirst();
		return new Livro(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4));
	}

	@Override
	public List<Livro> listar() {
		DataBase db = new DataBase(context);
		SQLiteDatabase sdb = db.getReadableDatabase();
		List<Livro> livros = new ArrayList<Livro>();
		Cursor c = sdb.query("livros", new String[]{"_id", "isbn", "titulo", "autor", "ano"}, null, null, null, null, null, null);
		
		if(c.moveToFirst()) {
			do {
				livros.add(new Livro(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
			} while (c.moveToNext());
			return livros;
		} else {
			return null;
		}
		
	}

	@Override
	public void atualiza(Livro e) {
		DataBase db = new DataBase(context);
		SQLiteDatabase sdb = db.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("isbn", e.getIsbn());
		values.put("titulo", e.getTitulo());
		values.put("autor", e.getAutor());
		values.put("ano", e.getAno());
		sdb.update("livros", values, "_id = ?", new String[]{e.getId()+""});
		sdb.close();
	}

}
