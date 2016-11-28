package com.example.leotoscana.petagram.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leotoscana.petagram.Adapter.MascotaAdaptador;
import com.example.leotoscana.petagram.IRview;
import com.example.leotoscana.petagram.Model.Mascota;
import com.example.leotoscana.petagram.Presentador.IRViewPresentador;
import com.example.leotoscana.petagram.Presentador.RViewPresentador;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements IRview{

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRViewPresentador presentador;

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
        presentador = new RViewPresentador(this,getContext());

        return v;
    }


    @Override
    public void generarLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
