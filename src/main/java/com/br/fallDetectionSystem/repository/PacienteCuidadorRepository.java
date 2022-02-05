package com.br.fallDetectionSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.PacienteCuidador;

public interface PacienteCuidadorRepository extends CrudRepository<PacienteCuidador, Integer>{

	@Query(value="select id, paciente_id, cuidador_id from paciente_cuidador where cuidador_id = ?1", nativeQuery = true)
	public List <PacienteCuidador> findPacienteByCuidadorId(int cuidador_id);
	
	@Query(value="select id, paciente_id, cuidador_id from paciente_cuidador where paciente_id = ?1", nativeQuery = true)
	public List <PacienteCuidador> findCuidadorByPacienteId(int paciente_id);
	
}