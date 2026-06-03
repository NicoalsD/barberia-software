package com.senorturno.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senorturno.model.Servicio;
import com.senorturno.service.ServicioService;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.crearServicio(servicio));
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listarServicios() {
        return ResponseEntity.ok(servicioService.listarServicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicio(
            @PathVariable @Parameter(description = "ID del servicio", example = "64f1a2b3c4d5e6f7a8b9c0d3") String id) {
        return ResponseEntity.ok(servicioService.obtenerServicio(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Servicio> actualizarServicio(
            @PathVariable @Parameter(description = "ID del servicio", example = "64f1a2b3c4d5e6f7a8b9c0d3") String id,
            @RequestBody Servicio datos) {
        return ResponseEntity.ok(servicioService.actualizarServicio(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(
            @PathVariable @Parameter(description = "ID del servicio", example = "64f1a2b3c4d5e6f7a8b9c0d3") String id) {
        servicioService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}
