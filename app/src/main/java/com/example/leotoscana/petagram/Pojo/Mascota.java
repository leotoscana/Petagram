package com.example.leotoscana.petagram.Pojo;


import java.util.ArrayList;

public class Mascota {

    private String  nombre;
    private int     imagen;
    private boolean favorito;
    private int     numero;

    public Mascota(String nombre, int imagen, int numero) {
        this.nombre   = nombre;
        this.imagen   = imagen;
        this.numero   = numero;
        this.favorito = false;
    }

    public Mascota(String nombre, int imagen, int numero, boolean favorito) {
        this.nombre   = nombre;
        this.imagen   = imagen;
        this.numero   = numero;
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
