package com.br.fallDetectionSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.model.PacienteCuidadorId;

public interface PacienteCuidadorRepository extends CrudRepository<PacienteCuidador, PacienteCuidadorId>{

}
