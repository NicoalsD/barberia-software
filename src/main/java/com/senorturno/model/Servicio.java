package com.senorturno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "servicios")
public class Servicio {

    @Id
    @Schema(example = "64f1a2b3c4d5e6f7a8b9c0d3")
    private String id;

    @Schema(example = "Corte de Cabello Premium")
    private String nombre;

    @Schema(example = "30")
    private int duracionMinutos;

    @Schema(description = "Tipo de servicio", example = "CORTE_CABELLO")
    private TipoServicio tipo;

    public Servicio() {
    }

    public Servicio(String id, String nombre, int duracionMinutos, TipoServicio tipo) {
        this.id = id;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }
}
