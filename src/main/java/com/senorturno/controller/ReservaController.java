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
import io.swagger.v3.oas.annotations.Parameter;

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
    public ResponseEntity<Reserva> cambiarEstado(
            @PathVariable @Parameter(description = "ID de la reserva", example = "64f1a2b3c4d5e6f7a8b9c0d4") String id,
            @RequestParam @Parameter(description = "Nuevo estado de la reserva") EstadoReserva estado) {
        return ResponseEntity.ok(reservaService.actualizarEstado(id, estado));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Reserva>> historialCliente(
            @PathVariable @Parameter(description = "ID del cliente", example = "64f1a2b3c4d5e6f7a8b9c0d1") String clienteId) {
        return ResponseEntity.ok(reservaService.historialCliente(clienteId));
    }

    @GetMapping("/barbero/{barberoId}")
    public ResponseEntity<List<Reserva>> agendaBarbero(
            @PathVariable @Parameter(description = "ID del barbero", example = "64f1a2b3c4d5e6f7a8b9c0d2") String barberoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "Fecha de la agenda (YYYY-MM-DD)", example = "2026-06-15") LocalDate fecha) {
        return ResponseEntity.ok(reservaService.agendaBarbero(barberoId, fecha));
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> reservasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "Fecha inicial del período (YYYY-MM-DD)", example = "2026-06-01") LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "Fecha final del período (YYYY-MM-DD)", example = "2026-06-30") LocalDate hasta) {
        return ResponseEntity.ok(reservaService.reservasPorPeriodo(desde, hasta));
    }
}
