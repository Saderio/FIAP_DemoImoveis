package br.com.caiosaderio.demoimobiliaria.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by caiosaderio on 10/3/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "fiap_demo_imobiliarias.db";
    private static final Integer VERSAO_BRANCO = 1;

    //DATABASE SQL STRUCTURE
    private static  final String imoveisTableString = "CREATE TABLE IF NOT EXISTS imoveis(_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
            +"nome_contato TEXT NOT NULL,"
            +"telefone TEXT,"
            +"tamanho INTEGER NOT NULL,"
            +"tipo INTEGER NOT NULL,"
            +"em_construcao INTEGER NOT NULL DEFAULT 0,"
            +"observacao TEXT,"
            +"latitude NUMERIC,"
            +"longitude NUMERIC,"
            +"foto_path TEXT,"
            +"ativo INTEGER NOT NULL DEFAULT 1,"
            +"user_cadastrou INTEGER,"
            +"favorito INTEGER NOT NULL DEFAULT 0);";

    private static final String dropTableImoveisString = "DROP TABLE IF EXISTS imoveis;";

    private static final String usuarioTableString = "CREATE IF NOT EXISTS user(_id INTEGER NOT NULL PRIMARY KEY AUTO INCREMENT,"
            +"login TEXT NOT NULL,"
            +"password TEXT NOT NULL"
            +");";

    private static final String dropTableUsuarioString = "DROP TABLE IF EXISTS user;";

    public DBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BRANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(imoveisTableString);
        db.execSQL(usuarioTableString);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DESTROI AS TABELAS
        db.execSQL(dropTableImoveisString);
        db.execSQL(dropTableUsuarioString);

        //EXECUTA CONSTRUTOR -> MAIS RAPIDO PARA TESTES SOMENTE
        onCreate(db);
    }
}
