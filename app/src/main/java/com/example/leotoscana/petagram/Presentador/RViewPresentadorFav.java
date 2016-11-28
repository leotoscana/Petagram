package com.example.leotoscana.petagram.Presentador;

import android.content.Context;

import com.example.leotoscana.petagram.IRview;
import com.example.leotoscana.petagram.Model.ConstructorMascotas;
import com.example.leotoscana.petagram.Model.Mascota;

import java.util.ArrayList;

/**
 * Created by LeoToscana on 27/11/2016.
 */

public class RViewPresentadorFav implements IRViewPresentador{

    private IRview iRecyclerView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public  RViewPresentadorFav(IRview iRecyclerView, Context context) {
        this.iRecyclerView = iRecyclerView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosFav();
        mostrarMascotasRv();
    }

    @Override
    public void mostrarMascotasRv() {
        iRecyclerView.inicializarAdaptadorRV(iRecyclerView.crearAdaptador(mascotas));
        iRecyclerView.generarLinearLayout();
    }
}
