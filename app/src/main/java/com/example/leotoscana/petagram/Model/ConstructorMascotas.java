package com.example.leotoscana.petagram.Model;

import android.content.ContentValues;
import android.content.Context;

import com.example.leotoscana.petagram.BaseDatos.BaseDatos;
import com.example.leotoscana.petagram.BaseDatos.Constantes;
import com.example.leotoscana.petagram.R;

import java.util.ArrayList;

/**
 * Created by LeoToscana on 26/11/2016.
 */

public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return  db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerDatosFav() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        BaseDatos db = new BaseDatos(context);
        for (Mascota pet:db.obtenerTodasLasMascotas()){
            for (Mascota petFav:db.obtenerMascotasFav())
            if (pet.getId()==petFav.getId()){
                mascotas.add(pet);
            }
        }
        return mascotas;
    }


    public void insertarMascotas(BaseDatos db){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
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
        ContentValues contentValues;
        for (Mascota pet:mascotas){
            contentValues = new ContentValues();
            contentValues.put(Constantes.TABLA_MASCOTAS_NOMBRE,pet.getNombre());
            contentValues.put(Constantes.TABLA_MASCOTAS_FOTO,pet.getImagen());
            contentValues.put(Constantes.TABLA_MASCOTAS_NUMERO,pet.getNumero());
            contentValues.put(Constantes.TABLA_MASCOTAS_FAVORITO,0);
            db.insertarMascota(contentValues);
        }
    }

    public void darFavMascotas(Mascota mascota){
        int fav= 1;
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLA_MASCOTAS_NUMERO, mascota.getNumero());
        contentValues.put(Constantes.TABLA_MASCOTAS_FAVORITO, fav);
        db.actualizarFavMascota(contentValues,mascota.getId());

    }
    public void insertarFavMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValuesFav = new ContentValues();
        contentValuesFav.put(Constantes.TABLA_FAVORITO_ID_MASCOTA,mascota.getId());
        db.insertarMascotaFav(contentValuesFav);
    }

}
