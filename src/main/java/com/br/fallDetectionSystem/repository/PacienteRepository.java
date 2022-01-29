package com.br.fallDetectionSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Integer>{
	Paciente findById(int id);
}
