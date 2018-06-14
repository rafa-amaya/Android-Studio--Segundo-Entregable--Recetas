package com.example.rafael.recetas;

import java.io.Serializable;

public class Receta implements Serializable {


    private int foto;
    private int titulo;
    private int ingrediente;
    private int receta;


    public Receta(int foto, int titulo, int ingrediente, int receta) {
        this.titulo = titulo;
        this.ingrediente = ingrediente;
        this.foto = foto;
        this.receta = receta;
    }

    public Receta(int titulo, int foto) {
        this.titulo = titulo;

        this.foto = foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public void setIngrediente(int ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    public int getFoto() {
        return foto;
    }

    public int getTitulo() {
        return titulo;
    }

    public int getIngrediente() {
        return ingrediente;
    }

    public int getReceta() {
        return receta;
    }
}



