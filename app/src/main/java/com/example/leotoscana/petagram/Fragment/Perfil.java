package com.example.leotoscana.petagram.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leotoscana.petagram.Adapter.PerfilAdaptador;
import com.example.leotoscana.petagram.Model.Mascota;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public Perfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.recycler_perfil);
        listaMascotas.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);

        iniciarMascotas();
        iniciarAdaptador();

        return v;
    }

    public void iniciarAdaptador() {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucky", R.drawable.dog_face_1, 3));
        mascotas.add(new Mascota("Tomy", R.drawable.dog_face_1, 4));
        mascotas.add(new Mascota("Yara", R.drawable.dog_face_1, 4));
        mascotas.add(new Mascota("Picha", R.drawable.dog_face_1, 5));
        mascotas.add(new Mascota("Wallace", R.drawable.dog_face_1, 6));
        mascotas.add(new Mascota("Luna", R.drawable.dog_face_1, 1));
        mascotas.add(new Mascota("Tota", R.drawable.dog_face_1, 2));
        mascotas.add(new Mascota("Carmela", R.drawable.dog_face_1, 3));
        mascotas.add(new Mascota("Lara", R.drawable.dog_face_1, 3));
        mascotas.add(new Mascota("Barbon", R.drawable.dog_face_1, 9));
        mascotas.add(new Mascota("Lucky",R.drawable.dog_face_1,7));
        mascotas.add(new Mascota("Lucky",R.drawable.dog_face_1,3));
    }

}
