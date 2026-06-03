package com.senorturno.service;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senorturno.dto.BarberoRequestDTO;
import com.senorturno.dto.ClienteRequestDTO;
import com.senorturno.model.Barbero;
import com.senorturno.model.Cliente;
import com.senorturno.model.RolUsuario;
import com.senorturno.model.Usuario;
import com.senorturno.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Cliente registrarCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setRol(RolUsuario.CLIENTE);
        cliente.setHistorialReservas(new ArrayList<>());
        return usuarioRepository.save(cliente);
    }

    public Cliente obtenerCliente(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        if (!(usuario instanceof Cliente)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id no corresponde a un cliente");
        }
        return (Cliente) usuario;
    }

    public Cliente actualizarCliente(String id, ClienteRequestDTO dto) {
        Cliente cliente = obtenerCliente(id);
        if (dto.getNombre() != null) cliente.setNombre(dto.getNombre());
        if (dto.getTelefono() != null) cliente.setTelefono(dto.getTelefono());
        return usuarioRepository.save(cliente);
    }

    public Barbero registrarBarbero(BarberoRequestDTO dto) {
        Barbero barbero = new Barbero();
        barbero.setNombre(dto.getNombre());
        barbero.setTelefono(dto.getTelefono());
        barbero.setEmail(dto.getEmail());
        barbero.setRol(RolUsuario.BARBERO);
        barbero.setDescripcion(dto.getDescripcion());
        return usuarioRepository.save(barbero);
    }

    public Barbero obtenerBarbero(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Barbero no encontrado"));
        if (!(usuario instanceof Barbero)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id no corresponde a un barbero");
        }
        return (Barbero) usuario;
    }
}
