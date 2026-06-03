package com.senorturno.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class ReservaRequestDTO {

    @Schema(example = "64f1a2b3c4d5e6f7a8b9c0d1")
    private String clienteId;

    @Schema(example = "64f1a2b3c4d5e6f7a8b9c0d2")
    private String barberoId;

    @Schema(example = "64f1a2b3c4d5e6f7a8b9c0d3")
    private String servicioId;

    @Schema(example = "2026-06-15")
    private LocalDate fecha;

    @Schema(type = "string", pattern = "HH:mm:ss", example = "14:30:00")
    private LocalTime horaInicio;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getBarberoId() {
        return barberoId;
    }

    public void setBarberoId(String barberoId) {
        this.barberoId = barberoId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
}
