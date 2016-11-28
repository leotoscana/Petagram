package com.example.leotoscana.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.leotoscana.petagram.Adapter.MascotaAdaptador;
import com.example.leotoscana.petagram.Model.Mascota;
import com.example.leotoscana.petagram.Presentador.IRViewPresentador;
import com.example.leotoscana.petagram.Presentador.RViewPresentador;
import com.example.leotoscana.petagram.Presentador.RViewPresentadorFav;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity implements IRview{

    private RecyclerView       listaMascotas;
    private ArrayList<Mascota> mascotas;
    private IRViewPresentador  presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar miAcbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(miAcbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        miAcbar.setLogo(R.drawable.ic_pets);

        listaMascotas = (RecyclerView) findViewById(R.id.recyclerDos);
        listaMascotas.setHasFixedSize(true);
        presentador = new RViewPresentadorFav(this,getBaseContext());

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufav,menu);
        return true;
    }

    public void generarLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        ArrayList<Mascota> mascotasFav = new ArrayList<>();
        for (int i=1;i<=5&&i<mascotas.size();i++){
            mascotasFav.add(mascotas.get(mascotas.size()-i));
        }
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFav,this);
        return adaptador;
    }

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
