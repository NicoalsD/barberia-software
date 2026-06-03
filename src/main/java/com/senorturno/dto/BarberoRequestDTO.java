package com.senorturno.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class BarberoRequestDTO {

    @Schema(example = "Carlos Barber")
    private String nombre;

    @Schema(example = "+573117654321")
    private String telefono;

    @Schema(example = "carlos.barber@example.com")
    private String email;

    @Schema(example = "Experto en cortes modernos y perfilado de barba.")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
