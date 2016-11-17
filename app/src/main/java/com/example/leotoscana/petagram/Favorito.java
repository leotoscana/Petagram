package com.example.leotoscana.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.leotoscana.petagram.Adapter.MascotaAdaptador;
import com.example.leotoscana.petagram.Pojo.Mascota;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity {

    private RecyclerView       listaMascotas;
    private ArrayList<Mascota> mascotas;

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

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        parametro();
        iniciarAdapt();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufav,menu);
        return true;
    }

    public void iniciarAdapt() {
        MascotaAdaptador adapt = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adapt);
    }

    public void parametro(){
        Bundle parametro = getIntent().getExtras();
        String[] nombre  = parametro.getStringArray("Nombre");
        int   [] imagen  = parametro.getIntArray   ("Imagen");
        int   [] numero  = parametro.getIntArray   ("Numero");
        mascotas=new ArrayList<>();
        for (int i=0;i<5;i++){
            mascotas.add(new Mascota(nombre[i],imagen[i],numero[i],true));
        }
    }
}
