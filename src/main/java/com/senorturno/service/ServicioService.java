package com.senorturno.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senorturno.model.Servicio;
import com.senorturno.repository.ServicioRepository;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicio(String id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado"));
    }

    public Servicio actualizarServicio(String id, Servicio datos) {
        Servicio servicio = obtenerServicio(id);
        if (datos.getNombre() != null) servicio.setNombre(datos.getNombre());
        if (datos.getDuracionMinutos() > 0) servicio.setDuracionMinutos(datos.getDuracionMinutos());
        if (datos.getTipo() != null) servicio.setTipo(datos.getTipo());
        return servicioRepository.save(servicio);
    }

    public void eliminarServicio(String id) {
        obtenerServicio(id);
        servicioRepository.deleteById(id);
    }
}
