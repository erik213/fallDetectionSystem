package com.br.fallDetectionSystem.service;

import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.model.PacienteCuidadorId;
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
	    Long cuidador_id = (long) cuidador.getId_cuidador();
	    Long paciente_id = (long) pacienteId;
    	pacienteCuidadorRepository.save(new PacienteCuidador(new PacienteCuidadorId(paciente_id, cuidador_id)));
    }
	
}
