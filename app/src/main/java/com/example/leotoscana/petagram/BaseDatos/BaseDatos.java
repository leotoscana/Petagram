package com.example.leotoscana.petagram.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.leotoscana.petagram.Model.Mascota;

import java.util.ArrayList;

/**
 * Created by LeoToscana on 26/11/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, Constantes.BASEDATOS, null, Constantes.BASEDATOS_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + Constantes.TABLA_MASCOTAS + "(" +
                Constantes.TABLA_MASCOTAS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TABLA_MASCOTAS_NOMBRE       + " TEXT," +
                Constantes.TABLA_MASCOTAS_FOTO         + " TEXT," +
                Constantes.TABLA_MASCOTAS_NUMERO       + " INTEGER," +
                Constantes.TABLA_MASCOTAS_FAVORITO     + " INTEGER" + ")";

        String queryCrearTablaMascotasFav = "CREATE TABLE " + Constantes.TABLA_FAVORITO + "(" +
                Constantes.TABLA_FAVORITO_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.TABLA_FAVORITO_ID_MASCOTA       + " INTEGER," +
                "FOREIGN KEY (" + Constantes.TABLA_FAVORITO_ID_MASCOTA + ") " +
                "REFERENCES " + Constantes.TABLA_MASCOTAS + "(" + Constantes.TABLA_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaMascotasFav);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + Constantes.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + Constantes.TABLA_FAVORITO);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Constantes.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));
            mascotaActual.setNumero(registros.getInt(3));
            mascotaActual.setFavorito(registros.getColumnIndex(Constantes.TABLA_MASCOTAS_FAVORITO)==1);
            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFav(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Constantes.TABLA_FAVORITO;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(registros.getColumnIndex(Constantes.TABLA_FAVORITO_ID_MASCOTA)));
            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TABLA_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarMascotaFav(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TABLA_FAVORITO,null, contentValues);
        db.close();
    }

    public void actualizarFavMascota(ContentValues contentValues,int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(Constantes.TABLA_MASCOTAS,contentValues,Constantes.TABLA_MASCOTAS_ID +"="+ id,null);
        db.update(Constantes.TABLA_MASCOTAS,contentValues,Constantes.TABLA_MASCOTAS_FAVORITO +"="+ id,null);
        db.close();
    }

}
