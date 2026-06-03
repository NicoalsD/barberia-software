package com.senorturno.service;

import java.time.LocalDate;
import java.time.LocalTime;

import com.senorturno.model.Barbero;
import com.senorturno.model.Cliente;
import com.senorturno.model.EstadoReserva;
import com.senorturno.model.Reserva;
import com.senorturno.model.Servicio;

public class ReservaBuilder {

    private Cliente cliente;
    private Barbero barbero;
    private Servicio servicio;
    private LocalDate fecha;
    private LocalTime horaInicio;

    public ReservaBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ReservaBuilder conBarbero(Barbero barbero) {
        this.barbero = barbero;
        return this;
    }

    public ReservaBuilder conServicio(Servicio servicio) {
        this.servicio = servicio;
        return this;
    }

    public ReservaBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ReservaBuilder conHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public Reserva build() {
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setBarbero(barbero);
        reserva.setServicio(servicio);
        reserva.setFecha(fecha);
        reserva.setHoraInicio(horaInicio);
        reserva.setEstado(EstadoReserva.PENDIENTE);
        return reserva;
    }
}
