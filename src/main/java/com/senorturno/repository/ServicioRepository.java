package com.senorturno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.senorturno.model.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
}
