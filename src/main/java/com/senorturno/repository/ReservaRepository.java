package com.senorturno.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.senorturno.model.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    List<Reserva> findByBarberoIdAndFecha(String barberoId, LocalDate fecha);

    List<Reserva> findByClienteId(String clienteId);

    List<Reserva> findByFechaBetween(LocalDate desde, LocalDate hasta);
}
