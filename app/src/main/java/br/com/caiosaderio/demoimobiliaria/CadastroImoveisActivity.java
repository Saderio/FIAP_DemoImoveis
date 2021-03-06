package br.com.caiosaderio.demoimobiliaria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;

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
    private Button btnExcluirImovel;
    private Float latitude;
    private Float longitude;
    private String foto;
    private Imovel imovel;
    private ImageView fotoImovel;
    private String caminhoArquivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imoveis);

        //SERIALIZABLE DATA
        imovel = (Imovel) getIntent().getSerializableExtra("imovelSelecionado");

        etNomeContato = (EditText) findViewById(R.id.etNomeContato);
        etTelContato = (EditText) findViewById(R.id.etTelContato);
        spTamanho = (Spinner) findViewById(R.id.spTamanho);
        spTipoImovel= (Spinner) findViewById(R.id.spTipoImovel);
        cbEmConstrucao = (CheckBox) findViewById(R.id.cbEmConstrucao);
        etObs = (EditText) findViewById(R.id.etObs);
        btnLocalizacao = (Button) findViewById(R.id.btnLocalizacao);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        btnSalvarImovel = (Button) findViewById(R.id.btnSalvarImovel);
        btnExcluirImovel = (Button) findViewById(R.id.btnExcluirImovel);
        fotoImovel = (ImageView) findViewById(R.id.fotoImovel);

        if(imovel != null && imovel.getId() != null){
            etNomeContato.setText(imovel.getNome());
            etTelContato.setText(imovel.getTelefone());
            spTamanho.setSelection(imovel.getTamanho());
            spTipoImovel.setSelection(imovel.getTipo());
            cbEmConstrucao.setChecked((imovel.getEmConstrucao() > 0) ? true : false);
            etObs.setText(imovel.getObs());
            btnLocalizacao.setText(getResources().getString(R.string.labelAlterar));
            btnExcluirImovel.setVisibility(View.VISIBLE);
        }

        fotoImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                caminhoArquivo = getFilesDir() +"/demoImobiliaria_"+System.currentTimeMillis()+".png";
                File foto = new File(caminhoArquivo);
                Uri localFoto = Uri.fromFile(foto);
                abrirCamera.putExtra(MediaStore.EXTRA_OUTPUT, localFoto);
                startActivityForResult(abrirCamera, 123);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){
                Bitmap imagem = BitmapFactory.decodeFile(caminhoArquivo);
                Bitmap imagemRduzida = Bitmap.createScaledBitmap(imagem,200,200,true);
                fotoImovel.setImageBitmap(imagemRduzida);
            }
        }
    }

    public void saveData(View v){
        String contato = etNomeContato.getText().toString();
        String telefone = etTelContato.getText().toString();
        Boolean emConstrucao = cbEmConstrucao.isChecked();
        String obs = etObs.getText().toString();

        Boolean gravar = true;
        if(imovel == null){
            imovel = new Imovel();
        }
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
        imovel.setAtivo(1);
        imovel.setObs(obs);
        imovel.setLatitude(latitude);
        imovel.setLongitude(longitude);
        imovel.setFoto(foto);
        if(gravar){
            ImovelDAO dao = new ImovelDAO(getApplicationContext());
            dao.salvar(imovel);
            finish();
        }

    }

    public void deleteData(View v){
        imovel.setAtivo(0);
        ImovelDAO dao = new ImovelDAO(getApplicationContext());
        dao.salvar(imovel);
        finish();
    }

}
