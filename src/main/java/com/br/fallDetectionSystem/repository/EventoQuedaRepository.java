package com.br.fallDetectionSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.fallDetectionSystem.model.EventoQueda;

public interface EventoQuedaRepository extends CrudRepository<EventoQueda, Integer>{

	@Query(value="select id_evento_queda, camera_id, paciente_id, data_hora from evento_queda where paciente_id = ?1", nativeQuery = true)
	public List <EventoQueda> findQuedaByPacienteId(int id_paciente);
}
