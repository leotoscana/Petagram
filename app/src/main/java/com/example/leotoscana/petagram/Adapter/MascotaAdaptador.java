package com.example.leotoscana.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leotoscana.petagram.Model.ConstructorMascotas;
import com.example.leotoscana.petagram.Model.Mascota;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;


/**
 * Created by LeoToscana on 28/10/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.crview,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota=mascotas.get(position);
        mascotaViewHolder.img.setImageResource(mascota.getImagen());
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.numero.setText(String.valueOf(mascota.getNumero()));
        if (mascota.isFavorito()){
            mascotaViewHolder.imgB.setImageResource(R.drawable.hueso_dorado);
        }
        else {
            mascotaViewHolder.imgB.setImageResource(R.drawable.hueso_blanco);
        }
        mascotaViewHolder.imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fav = Integer.parseInt(mascotaViewHolder.numero.getText().toString());
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                if (mascota.isFavorito() == false){
                    mascota.setFavorito(true);
                    mascota.setNumero(fav + 1);
                    constructorMascotas.darFavMascotas(mascota);
                    constructorMascotas.insertarFavMascota(mascota);
                    mascotaViewHolder.imgB.setImageResource(R.drawable.hueso_dorado);
                }
                else {
                    mascota.setFavorito(false);
                    mascota.setNumero(fav - 1);
                    mascotaViewHolder.imgB.setImageResource(R.drawable.hueso_blanco);
                }
                mascotaViewHolder.numero.setText(String.valueOf(mascota.getNumero()));
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
