package com.example.leotoscana.petagram;


import java.util.ArrayList;

public class Mascota {

    private String  nombre;
    private int     imagen;
    private boolean favorito;
    private String     numero;

    public Mascota(String nombre, int imagen, String numero) {
        this.nombre   = nombre;
        this.imagen   = imagen;
        this.numero   = numero;
        this.favorito = false;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
