package com.senorturno.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senorturno.dto.BarberoRequestDTO;
import com.senorturno.dto.ClienteRequestDTO;
import com.senorturno.model.Barbero;
import com.senorturno.model.Cliente;
import com.senorturno.service.UsuarioService;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarCliente(dto));
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerCliente(
            @PathVariable @Parameter(description = "ID del cliente", example = "64f1a2b3c4d5e6f7a8b9c0d1") String id) {
        return ResponseEntity.ok(usuarioService.obtenerCliente(id));
    }

    @PatchMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable @Parameter(description = "ID del cliente", example = "64f1a2b3c4d5e6f7a8b9c0d1") String id,
            @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.actualizarCliente(id, dto));
    }

    @PostMapping("/barberos")
    public ResponseEntity<Barbero> registrarBarbero(@RequestBody BarberoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarBarbero(dto));
    }

    @GetMapping("/barberos/{id}")
    public ResponseEntity<Barbero> obtenerBarbero(
            @PathVariable @Parameter(description = "ID del barbero", example = "64f1a2b3c4d5e6f7a8b9c0d2") String id) {
        return ResponseEntity.ok(usuarioService.obtenerBarbero(id));
    }
}
