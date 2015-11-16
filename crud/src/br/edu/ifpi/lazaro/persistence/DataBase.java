package br.edu.ifpi.lazaro.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
	
	private static final String DATA_BASE_NAME = "biblioteca";
	private static final int DATA_BASE_VERSION = 1;
	
	public DataBase(Context context) {
		super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table livros(" +
				"_id integer primary key autoincrement," +
				"isbn text," +
				"titulo text," +
				"autor text," +
				"ano integer," +
				");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table livros if exists");
		onCreate(db);
	}

}
