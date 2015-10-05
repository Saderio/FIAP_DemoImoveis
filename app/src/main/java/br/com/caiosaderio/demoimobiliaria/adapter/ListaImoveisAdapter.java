package br.com.caiosaderio.demoimobiliaria.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

        View view = activity.getLayoutInflater().inflate(R.layout.row_layout,null);
        Imovel imovel = imoveis.get(position);

        ImageView ivImovel = (ImageView) view.findViewById(R.id.ivListImovel);
        TextView tvContato = (TextView) view.findViewById(R.id.tvContato);
        TextView tvTamanho = (TextView) view.findViewById(R.id.tvTamanho);
        TextView tvTipo = (TextView) view.findViewById(R.id.tvTipo);
        TextView tvConstrucao = (TextView) view.findViewById(R.id.tvConstrucao);
        TextView tvObservacao = (TextView) view.findViewById(R.id.tvObs);

        if(imovel.getFoto().length() > 0){
            Bitmap bitmap;
            bitmap = BitmapFactory.decodeFile(imovel.getFoto());
            ivImovel.setImageBitmap(bitmap);
        }else{
            ivImovel.setImageResource(R.mipmap.ic_launcher);
        }
        tvContato.setText(imovel.getNome());
        tvTamanho.setText(view.getResources().getStringArray(R.array.tamanhoImovel)[imovel.getTamanho()].toString());
        tvTipo.setText(view.getResources().getStringArray(R.array.tipoImovel)[imovel.getTipo()].toString());
        tvConstrucao.setText((view.getResources().getStringArray(R.array.simNao)[imovel.getEmConstrucao()+1]).toString());
        tvObservacao.setText(imovel.getObs());
        return convertView;
    }
}
