package com.example.leotoscana.petagram;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    String [] mascotaNombre;
    int    [] mascotaImagen;
    String [] mascotaNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miAcbar = (Toolbar) findViewById(R.id.miAcbar);
        setSupportActionBar(miAcbar);
        miAcbar.setLogo(R.drawable.ic_pets);

        listaMascotas = (RecyclerView) findViewById(R.id.recycler);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        iniciarMascotas();
        iniciarAdaptador();
    }

    public void iniciarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucky", R.drawable.dog_face_1, "3"));
        mascotas.add(new Mascota("Tomy", R.drawable.dog_face_2, "4"));
        mascotas.add(new Mascota("Yara", R.drawable.dog_face_3, "4"));
        mascotas.add(new Mascota("Picha", R.drawable.dog_face_4, "5"));
        mascotas.add(new Mascota("Wallace", R.drawable.dog_face_5, "6"));
        mascotas.add(new Mascota("Luna", R.drawable.dog_face_6, "1"));
        mascotas.add(new Mascota("Tota", R.drawable.dog_face_7, "2"));
        mascotas.add(new Mascota("Carmela", R.drawable.dog_faces_8, "3"));
        mascotas.add(new Mascota("Lara", R.drawable.dog_face_9, "3"));
        mascotas.add(new Mascota("Barbon", R.drawable.dog_face_10, "9"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrella:
                mascotasFavoritas(mascotas);
                Intent intent = new Intent(this,Favorito.class);
                intent.putExtra("Nombre",mascotaNombre);
                intent.putExtra("Imagen",mascotaImagen);
                intent.putExtra("Numero",mascotaNumero);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mascotasFavoritas(ArrayList<Mascota> mascotas){
        mascotaNombre=new String [5];
        mascotaImagen=new int    [5];
        mascotaNumero=new String [5];
        int i=0;
        for (Mascota pet:mascotas) {
            if(pet.isFavorito()){
                mascotaNombre[i] = pet.getNombre();
                mascotaNumero[i] = pet.getNumero();
                mascotaImagen[i] = pet.getImagen();
                i++;
                if(i==5){
                    i=0;
                }
            }
        }
    }
}