package com.senorturno.model;

public class Barbero extends Usuario {

    private String descripcion;

    public Barbero() {
    }

    public Barbero(String id, String nombre, String telefono, String email, RolUsuario rol, String descripcion) {
        super(id, nombre, telefono, email, rol);
        this.descripcion = descripcion;
    }

    @Override
    public String getInfoContacto() {
        return getNombre() + " - " + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
