package com.senorturno.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senorturno.dto.ReservaRequestDTO;
import com.senorturno.model.EstadoReserva;
import com.senorturno.model.Reserva;
import com.senorturno.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody ReservaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.crearReserva(dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Reserva> cambiarEstado(@PathVariable String id, @RequestParam String estado) {
        return ResponseEntity.ok(reservaService.actualizarEstado(id, EstadoReserva.valueOf(estado)));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Reserva>> historialCliente(@PathVariable String clienteId) {
        return ResponseEntity.ok(reservaService.historialCliente(clienteId));
    }

    @GetMapping("/barbero/{barberoId}")
    public ResponseEntity<List<Reserva>> agendaBarbero(
            @PathVariable String barberoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(reservaService.agendaBarbero(barberoId, fecha));
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> reservasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        return ResponseEntity.ok(reservaService.reservasPorPeriodo(desde, hasta));
    }
}
