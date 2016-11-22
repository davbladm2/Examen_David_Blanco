package com.example.dm2.examen_david_blanco;


public class Localidades {

    private String nombre;
    private String superficie;
    private String habitantes;
    private String web;

    public Localidades(String n, String s, String h, String w){
        nombre=n;
        superficie=s;
        habitantes=h;
        web=w;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperficie() {
        return superficie;
    }
    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(String habitantes) {
        this.habitantes = habitantes;
    }

    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }
}
