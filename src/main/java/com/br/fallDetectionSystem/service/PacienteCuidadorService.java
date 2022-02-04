package com.br.fallDetectionSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteCuidadorRepository;

@Service
public class PacienteCuidadorService {
	
	private CuidadorRepository cuidadorRepository;
	
	private PacienteCuidadorRepository pacienteCuidadorRepository;
	
	public PacienteCuidadorService(CuidadorRepository cuidadorRepository, PacienteCuidadorRepository pacienteCuidadorRepository) {
		this.cuidadorRepository = cuidadorRepository;
		this.pacienteCuidadorRepository = pacienteCuidadorRepository;
	}
	
	public void associatePacienteCuidador(int pacienteId, String username) {
    	Cuidador cuidador = cuidadorRepository.findByUsername(username);	
	    int cuidador_id = cuidador.getId_cuidador();
	    int paciente_id = pacienteId;
    	pacienteCuidadorRepository.save(new PacienteCuidador(paciente_id, cuidador_id));
    }
	
	public List<PacienteCuidador> findPacienteCuidador(int id_cuidador) {
		List <PacienteCuidador> pacienteCuidador = pacienteCuidadorRepository.findPacienteByCuidadorId(id_cuidador);
		return pacienteCuidador;
	}
	
}
