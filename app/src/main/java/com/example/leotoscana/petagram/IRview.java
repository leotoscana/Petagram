package com.example.leotoscana.petagram;

import com.example.leotoscana.petagram.Adapter.MascotaAdaptador;
import com.example.leotoscana.petagram.Model.Mascota;

import java.util.ArrayList;

/**
 * Created by LeoToscana on 26/11/2016.
 */

public interface IRview {
    public void generarLinearLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
