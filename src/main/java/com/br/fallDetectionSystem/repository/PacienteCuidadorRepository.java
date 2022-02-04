package com.br.fallDetectionSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.PacienteCuidador;

public interface PacienteCuidadorRepository extends CrudRepository<PacienteCuidador, Integer>{

	@Query(value="select id, id_paciente, id_cuidador from paciente_cuidador where id_cuidador = ?1", nativeQuery = true)
	public List <PacienteCuidador> findPacienteByCuidadorId(int id_cuidador);
	
}