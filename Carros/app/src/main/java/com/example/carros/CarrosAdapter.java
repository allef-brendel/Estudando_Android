package com.example.carros;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CarrosAdapter extends BaseAdapter {

    Context context;
    List<Carros> carros;

    public CarrosAdapter(Context context, List<Carros> carros) {
        this.context = context;
        this.carros = carros;
    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Carros carro = carros.get(i);
        View linha = LayoutInflater.from(context).inflate(R.layout.item_carro, null);

        ViewHolder holder = null;
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_carro, null);

            holder = new ViewHolder();
            holder.imgLogo = linha.findViewById(R.id.imgLogo);
            holder.txtModelo = linha.findViewById(R.id.txtModelo);
            holder.txtAno = linha.findViewById(R.id.txtAno);
            holder.txtCombustivel = linha.findViewById(R.id.txtCombustivel);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Resources res = context.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
        holder.imgLogo.setImageDrawable(logos.getDrawable(carro.fabricante));

        holder.txtModelo.setText(carro.modelo);
        holder.txtAno.setText(String.valueOf(carro.ano));
        holder.txtCombustivel.setText((carro.gasolina ? "G" : "") + (carro.etanol ? "E" : ""));

        return linha;
    }

    static class ViewHolder{
        ImageView imgLogo;
        TextView txtModelo;
        TextView txtAno;
        TextView txtCombustivel;
    }

}
