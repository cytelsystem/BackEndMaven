package com.odontologica.main.model;

public class Odontologo {

    private int id;
    private String nombre;
    private String apellido;
    private String numeroMatricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return ("Odonotologo Name:"+this.getNombre()+
                " Apellido: "+ this.getApellido() +
                " Matricula: "+ this.getNumeroMatricula() +
                " Id : " + this.getId());
    }
}
