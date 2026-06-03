package com.senorturno.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senorturno.dto.ReservaRequestDTO;
import com.senorturno.model.Barbero;
import com.senorturno.model.Cliente;
import com.senorturno.model.EstadoReserva;
import com.senorturno.model.Reserva;
import com.senorturno.model.Servicio;
import com.senorturno.model.Usuario;
import com.senorturno.repository.ReservaRepository;
import com.senorturno.repository.ServicioRepository;
import com.senorturno.repository.UsuarioRepository;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicioRepository servicioRepository;

    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository,
                          ServicioRepository servicioRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.servicioRepository = servicioRepository;
    }

    public Reserva crearReserva(ReservaRequestDTO dto) {
        Cliente cliente = buscarCliente(dto.getClienteId());
        Barbero barbero = buscarBarbero(dto.getBarberoId());
        Servicio servicio = buscarServicio(dto.getServicioId());

        if (!verificarDisponibilidad(dto.getBarberoId(), dto.getFecha(), dto.getHoraInicio())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El barbero no esta disponible en ese horario");
        }

        Reserva reserva = new ReservaBuilder()
                .conCliente(cliente)
                .conBarbero(barbero)
                .conServicio(servicio)
                .conFecha(dto.getFecha())
                .conHoraInicio(dto.getHoraInicio())
                .build();

        return reservaRepository.save(reserva);
    }

    public Reserva actualizarEstado(String id, EstadoReserva nuevoEstado) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
        reserva.cambiarEstado(nuevoEstado);
        return reservaRepository.save(reserva);
    }

    public List<Reserva> historialCliente(String clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    public List<Reserva> agendaBarbero(String barberoId, LocalDate fecha) {
        return reservaRepository.findByBarberoIdAndFecha(barberoId, fecha);
    }

    public List<Reserva> reservasPorPeriodo(LocalDate desde, LocalDate hasta) {
        return reservaRepository.findByFechaBetween(desde, hasta);
    }

    public boolean verificarDisponibilidad(String barberoId, LocalDate fecha, LocalTime hora) {
        List<Reserva> reservas = reservaRepository.findByBarberoIdAndFecha(barberoId, fecha);
        for (Reserva reserva : reservas) {
            if (reserva.getEstado() != EstadoReserva.CANCELADA && reserva.getHoraInicio().equals(hora)) {
                return false;
            }
        }
        return true;
    }

    private Cliente buscarCliente(String clienteId) {
        Usuario usuario = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        if (!(usuario instanceof Cliente)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id no corresponde a un cliente");
        }
        return (Cliente) usuario;
    }

    private Barbero buscarBarbero(String barberoId) {
        Usuario usuario = usuarioRepository.findById(barberoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barbero no encontrado"));
        if (!(usuario instanceof Barbero)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id no corresponde a un barbero");
        }
        return (Barbero) usuario;
    }

    private Servicio buscarServicio(String servicioId) {
        return servicioRepository.findById(servicioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servicio no encontrado"));
    }
}
