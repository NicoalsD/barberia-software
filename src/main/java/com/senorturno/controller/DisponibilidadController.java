package com.senorturno.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senorturno.service.ReservaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/disponibilidad")
public class DisponibilidadController {

    private final ReservaService reservaService;

    public DisponibilidadController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<Boolean> verificarDisponibilidad(
            @RequestParam @Parameter(description = "ID del barbero", example = "64f1a2b3c4d5e6f7a8b9c0d2") String barberoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "Fecha a consultar (YYYY-MM-DD)", example = "2026-06-15") LocalDate fecha,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @Parameter(description = "Hora a consultar (HH:mm)", schema = @Schema(type = "string", format = "", example = "14:30")) LocalTime hora) {
        return ResponseEntity.ok(reservaService.verificarDisponibilidad(barberoId, fecha, hora));
    }
}
