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

}
