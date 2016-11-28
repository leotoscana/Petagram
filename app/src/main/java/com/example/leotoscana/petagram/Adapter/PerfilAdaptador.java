package com.example.leotoscana.petagram.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leotoscana.petagram.Model.Mascota;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;

/**
 * Created by LeoToscana on 15/11/2016.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    private ArrayList<Mascota> mascotas;

    public PerfilAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_perfil,parent,false);
        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilAdaptador.PerfilViewHolder perfilViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        perfilViewHolder.img.setImageResource(mascota.getImagen());
        perfilViewHolder.numero.setText(String.valueOf(mascota.getNumero()));
    }

    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView   img;
        private TextView    numero;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            img    = (ImageView)   itemView.findViewById(R.id.pimagen);
            numero = (TextView)    itemView.findViewById(R.id.pnumero);
        }
    }
}
