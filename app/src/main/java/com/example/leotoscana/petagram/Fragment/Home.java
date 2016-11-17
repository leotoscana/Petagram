package com.example.leotoscana.petagram.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.leotoscana.petagram.Acerca;
import com.example.leotoscana.petagram.Adapter.MascotaAdaptador;
import com.example.leotoscana.petagram.Contacto;
import com.example.leotoscana.petagram.Favorito;
import com.example.leotoscana.petagram.MainActivity;
import com.example.leotoscana.petagram.Pojo.Mascota;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.recycler);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        iniciarMascotas();
        iniciarAdaptador();

        return v;
    }

    public void iniciarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucky", R.drawable.dog_face_1, 3));
        mascotas.add(new Mascota("Tomy", R.drawable.dog_face_2, 4));
        mascotas.add(new Mascota("Yara", R.drawable.dog_face_3, 4));
        mascotas.add(new Mascota("Picha", R.drawable.dog_face_4, 5));
        mascotas.add(new Mascota("Wallace", R.drawable.dog_face_5, 6));
        mascotas.add(new Mascota("Luna", R.drawable.dog_face_6, 1));
        mascotas.add(new Mascota("Tota", R.drawable.dog_face_7, 2));
        mascotas.add(new Mascota("Carmela", R.drawable.dog_faces_8, 3));
        mascotas.add(new Mascota("Lara", R.drawable.dog_face_9, 3));
        mascotas.add(new Mascota("Barbon", R.drawable.dog_face_10, 9));
    }

}
