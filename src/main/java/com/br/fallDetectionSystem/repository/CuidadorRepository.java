package com.br.fallDetectionSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.Cuidador;

public interface CuidadorRepository extends CrudRepository<Cuidador, Integer>{
	Cuidador findById(int id);
	
	Cuidador findByUsername(String username);
}