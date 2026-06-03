package com.senorturno.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private EstadoReserva estado;
    private Cliente cliente;
    private Barbero barbero;
    private Servicio servicio;

    public Reserva() {
    }

    public Reserva(String id, LocalDate fecha, LocalTime horaInicio, EstadoReserva estado,
                   Cliente cliente, Barbero barbero, Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
        this.cliente = cliente;
        this.barbero = barbero;
        this.servicio = servicio;
    }

    public void cambiarEstado(EstadoReserva nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
