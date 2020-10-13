package com.juliogarcia.netmascotas;

public class Mascota {
    private int foto;
    private String nombre;
    private int huesos;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getHuesos() {
        return huesos;
    }

    public void setHuesos(int huesos) {
        this.huesos = huesos;
    }

    public Mascota( int foto,String nombre, int huesos) {
        this.foto = foto;
        this.nombre = nombre;
        this.huesos = huesos;

    }
}
