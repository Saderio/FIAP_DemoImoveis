package br.com.caiosaderio.demoimobiliaria.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.List;

import br.com.caiosaderio.demoimobiliaria.R;
import br.com.caiosaderio.demoimobiliaria.model.Imovel;

/**
 * Created by caiosaderio on 10/4/15.
 */
public class ListaImoveisAdapter extends BaseAdapter {

    private final List<Imovel> imoveis;
    private final Activity activity;

    public ListaImoveisAdapter(List<Imovel> imoveis, Activity activity) {
        this.imoveis = imoveis;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return imoveis.size();
    }

    @Override
    public Object getItem(int position) {
        return imoveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imoveis.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View linha = activity.getLayoutInflater().inflate(R.layout.row_layout, null);
        Imovel imovel = imoveis.get(position);

        ImageView ivImovel = (ImageView) linha.findViewById(R.id.ivListImovel);
        TextView tvContato = (TextView) linha.findViewById(R.id.tvContato);
        TextView tvTamanho = (TextView) linha.findViewById(R.id.tvTamanho);
        TextView tvTipo = (TextView) linha.findViewById(R.id.tvTipo);
        TextView tvConstrucao = (TextView) linha.findViewById(R.id.tvConstrucao);
        //TextView tvObservacao = (TextView) linha.findViewById(R.id.tvObs);

        if(imovel.getFoto() != null && imovel.getFoto().length() > 0){
            Bitmap bitmap;
            bitmap = BitmapFactory.decodeFile(imovel.getFoto());
            Bitmap imagemReduzida = Bitmap.createScaledBitmap(bitmap,100,100,true);
            ivImovel.setImageBitmap(imagemReduzida);
        }

        tvContato.setText(imovel.getNome());
        tvTamanho.setText(linha.getResources().getStringArray(R.array.tamanhoImovel)[imovel.getTamanho()].toString());
        tvTipo.setText(linha.getResources().getStringArray(R.array.tipoImovel)[imovel.getTipo()].toString());
        tvConstrucao.setText((linha.getResources().getStringArray(R.array.simNao)[imovel.getEmConstrucao()]).toString());
        //tvObservacao.setText(imovel.getObs());

        return linha;
    }
}
