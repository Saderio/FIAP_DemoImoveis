package br.com.caiosaderio.demoimobiliaria;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.caiosaderio.demoimobiliaria.dao.ImovelDAO;
import br.com.caiosaderio.demoimobiliaria.model.Imovel;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private TextView tvNoImovel;
    private ListView listaImoveis;
    private ImovelDAO dao;
    private List<Imovel> imoveis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_main);

        dao = new ImovelDAO(this);
        imoveis = dao.listaAll();

        tvNoImovel = (TextView) findViewById(R.id.tvNoImovel);
        listaImoveis = (ListView) findViewById(R.id.listaImovies);
        fab = (FloatingActionButton) findViewById(R.id.fabAddImovel);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i = new Intent(getApplicationContext(),CadastroImoveisActivity.class);
                startActivity(i);
            }
        });
//        if(imoveis.size() > 0){
          //  carregaImoveis();
  //      }else{
            tvNoImovel.setVisibility(View.VISIBLE);
            listaImoveis.setVisibility(View.GONE);
    //    }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //carregaImoveis();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       // carregaImoveis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    public void carregaImoveis(){
        ArrayAdapter<Imovel> adapater = new ArrayAdapter<Imovel>(this, android.R.layout.simple_list_item_1, imoveis);
        listaImoveis.setAdapter(adapater);
    }
    */
}
