package com.senorturno.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ClienteRequestDTO {

    @Schema(example = "Juan Pérez")
    private String nombre;

    @Schema(example = "+573001234567")
    private String telefono;

    @Schema(example = "juan.perez@example.com")
    private String email;

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
}
