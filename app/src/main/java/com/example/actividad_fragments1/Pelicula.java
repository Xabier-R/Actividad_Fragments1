package com.example.actividad_fragments1;

import java.io.Serializable;
import java.util.Date;

public class Pelicula implements Serializable {
    private String titulo;
    private int imagen;
    private String año_estreno;
    private int duracion;
    private int recaudacion;


    public Pelicula(String titulo,int imagen, String fecha_estreno, int duracion, int recaudacion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.año_estreno = fecha_estreno;
        this.duracion = duracion;
        this.recaudacion=recaudacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño_estreno() {
        return año_estreno;
    }

    public void setAño_estreno(String año_estreno) {
        this.año_estreno = año_estreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }
}
