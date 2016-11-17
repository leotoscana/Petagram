package com.example.leotoscana.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.leotoscana.petagram.Adapter.PageAdapter;
import com.example.leotoscana.petagram.Fragment.Home;
import com.example.leotoscana.petagram.Fragment.Perfil;
import com.example.leotoscana.petagram.Pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar   toolbar;
    private TabLayout tab;
    private ViewPager view;
    private ArrayList<Fragment> fragments;
    String [] mascotaNombre;
    int    [] mascotaImagen;
    int    [] mascotaNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_pets);

        tab  = (TabLayout) findViewById(R.id.tab);
        view = (ViewPager) findViewById(R.id.view);
        setUpViewPager();
    }


    private ArrayList<Fragment> agregarFragment(){
        fragments = new ArrayList<>();
        fragments.add(new Home());
        fragments.add(new Perfil());
        return fragments;
    }

    private void setUpViewPager(){
        view.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tab.setupWithViewPager(view);
        tab.getTabAt(0).setIcon(R.drawable.ic_house);
        tab.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.estrella:
                Intent intent = new Intent(this,Favorito.class);
                mascotasFavoritas(Home.mascotas);
                intent.putExtra("Nombre",mascotaNombre);
                intent.putExtra("Imagen",mascotaImagen);
                intent.putExtra("Numero",mascotaNumero);
                startActivity(intent);
                break;
            case R.id.contacto:
                Intent i = new Intent(this,Contacto.class);
                startActivity(i);
                break;
            case R.id.acerca:
                Intent in = new Intent(this,Acerca.class);
                startActivity(in);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mascotasFavoritas(ArrayList<Mascota> mascotas){
        mascotaNombre = new String[5];
        mascotaImagen = new int   [5];
        mascotaNumero = new int   [5];
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