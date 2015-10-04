package br.com.caiosaderio.demoimobiliaria.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiosaderio on 10/3/15.
 */
public class Imovel {
    private DBHelper dbHelper;
    private Context ctx;

    public Imovel(Context ctx) {
        dbHelper = new DBHelper(ctx);
        this.ctx = ctx;
    }

    public void salvar(br.com.caiosaderio.demoimobiliaria.model.Imovel imovel) {
        if (imovel.getId() == null) {
            inserir(imovel);
        } else {
            atualizar(imovel);
        }
    }

    private void inserir(br.com.caiosaderio.demoimobiliaria.model.Imovel imovel) {
        ContentValues valores = new ContentValues();
        valores.put("nome_contato", imovel.getNome());
        valores.put("telefone", imovel.getTelefone());
        valores.put("tamanho", imovel.getTamanho());
        valores.put("tipo", imovel.getTipo());
        valores.put("em_construcao", imovel.getEmConstrucao());
        valores.put("observacao", imovel.getObs());
        valores.put("latitude", imovel.getLatitude());
        valores.put("longitude", imovel.getLongitude());
        valores.put("foto_path", imovel.getFoto());
        valores.put("ativo", imovel.getAtivo());
        valores.put("user_cadastrou", imovel.getUserCadastrou());
        valores.put("favorito", imovel.getFavorito());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long id = db.insert("imoveis", null, valores);
        imovel.setId(id);
        db.close();
    }

    private void atualizar(br.com.caiosaderio.demoimobiliaria.model.Imovel imovel) {
        ContentValues valores = new ContentValues();
        valores.put("nome_contato", imovel.getNome());
        valores.put("telefone", imovel.getTelefone());
        valores.put("tamanho", imovel.getTamanho());
        valores.put("tipo", imovel.getTipo());
        valores.put("em_construcao", imovel.getEmConstrucao());
        valores.put("observacao", imovel.getObs());
        valores.put("latitude", imovel.getLatitude());
        valores.put("longitude", imovel.getLongitude());
        valores.put("foto_path", imovel.getFoto());
        valores.put("ativo", imovel.getAtivo());
        valores.put("user_cadastrou", imovel.getUserCadastrou());
        valores.put("favorito", imovel.getFavorito());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.update("imoveis", valores, "_id=?", new String[]{imovel.getId().toString()});
        db.close();
    }

    public List<br.com.caiosaderio.demoimobiliaria.model.Imovel> listaAll() {
        List<br.com.caiosaderio.demoimobiliaria.model.Imovel> imoveis = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("imoveis", null, null, null, null, null, "nome ASC");

        try {
            while (cursor.moveToNext()) {
                br.com.caiosaderio.demoimobiliaria.model.Imovel imovel = new br.com.caiosaderio.demoimobiliaria.model.Imovel();
                imovel.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                imovel.setNome(cursor.getString(cursor.getColumnIndex("nome_contato")));
                imovel.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                imovel.setTamanho(cursor.getInt(cursor.getColumnIndex("tamanho")));
                imovel.setTipo(cursor.getInt(cursor.getColumnIndex("tipo")));
                imovel.setEmConstrucao(cursor.getInt(cursor.getColumnIndex("em_construcao")));
                imovel.setObs(cursor.getString(cursor.getColumnIndex("observacao")));
                imovel.setLatitude(cursor.getFloat(cursor.getColumnIndex("latitude")));
                imovel.setLongitude(cursor.getFloat(cursor.getColumnIndex("longitude")));
                imovel.setFoto(cursor.getString(cursor.getColumnIndex("foto_path")));
                imovel.setAtivo(cursor.getInt(cursor.getColumnIndex("ativo")));
                imovel.setUserCadastrou(cursor.getInt(cursor.getColumnIndex("user_cadastrou")));
                imovel.setFavorito(cursor.getInt(cursor.getColumnIndex("favorito")));
                imoveis.add(imovel);
            }
        } finally {
            cursor.close();
        }
        db.close();
        return imoveis;
    }
}
