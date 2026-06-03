package com.senorturno.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Reserva> historialReservas = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String id, String nombre, String telefono, String email, RolUsuario rol,
                   List<Reserva> historialReservas) {
        super(id, nombre, telefono, email, rol);
        this.historialReservas = historialReservas;
    }

    @Override
    public String getInfoContacto() {
        return getNombre() + " - " + getTelefono();
    }

    public List<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    public void setHistorialReservas(List<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }
}
