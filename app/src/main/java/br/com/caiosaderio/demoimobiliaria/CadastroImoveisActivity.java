package br.com.caiosaderio.demoimobiliaria;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.caiosaderio.demoimobiliaria.dao.ImovelDAO;
import br.com.caiosaderio.demoimobiliaria.model.Imovel;

public class CadastroImoveisActivity extends AppCompatActivity {

    private EditText etNomeContato;
    private EditText etTelContato;
    private Spinner spTamanho;
    private Spinner spTipoImovel;
    private CheckBox cbEmConstrucao;
    private EditText etObs;
    private Button btnLocalizacao;
    private Button btnFoto;
    private Button btnSalvarImovel;
    private Float latitude;
    private Float longitude;
    private String foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imoveis);

        etNomeContato = (EditText) findViewById(R.id.etNomeContato);
        etTelContato = (EditText) findViewById(R.id.etTelContato);
        spTamanho = (Spinner) findViewById(R.id.spTamanho);
        spTipoImovel= (Spinner) findViewById(R.id.spTipoImovel);
        cbEmConstrucao = (CheckBox) findViewById(R.id.cbEmConstrucao);
        etObs = (EditText) findViewById(R.id.etObs);
        btnLocalizacao = (Button) findViewById(R.id.btnLocalizacao);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnSalvarImovel = (Button) findViewById(R.id.btnSalvarImovel);



    }

    public void saveData(View v){
        String contato = etNomeContato.getText().toString();
        String telefone = etTelContato.getText().toString();
        Boolean emConstrucao = cbEmConstrucao.isChecked();
        String obs = etObs.getText().toString();

        Boolean gravar = true;
        Imovel imovel = new Imovel();
        if(contato.length() > 0){
            imovel.setNome(contato);
        }else{
            etNomeContato.requestFocus();
            gravar = false;
        }
        if(telefone.length() > 0){
            imovel.setTelefone(telefone);
        }else{
            etTelContato.requestFocus();
            gravar = false;
        }
        imovel.setTamanho(spTamanho.getSelectedItemPosition());
        imovel.setTipo(spTipoImovel.getSelectedItemPosition());
        imovel.setEmConstrucao((emConstrucao) ? 1 : 0);
        if(obs.length() > 0){
            imovel.setObs(obs);
        }else{
            etObs.requestFocus();
            gravar = false;
        }
        imovel.setLatitude(latitude);
        imovel.setLongitude(longitude);
        imovel.setFoto(foto);

        ImovelDAO dao = new ImovelDAO(getApplicationContext());
        dao.salvar(imovel);

    }

}
