package com.example.leotoscana.petagram;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


/**
 * Created by LeoToscana on 28/10/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;


    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.crview,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        mascotaViewHolder.img.setImageResource(mascota.getImagen());
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.numero.setText(mascota.getNumero());
        mascotaViewHolder.imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setFavorito(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        private ImageView   img;
        private TextView    nombre;
        private TextView    numero;
        private ImageButton imgB;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            img    = (ImageView)   itemView.findViewById(R.id.img);
            imgB   = (ImageButton) itemView.findViewById(R.id.imgB);
            nombre = (TextView)    itemView.findViewById(R.id.nombre);
            numero = (TextView)    itemView.findViewById(R.id.numero);
        }
    }
}
