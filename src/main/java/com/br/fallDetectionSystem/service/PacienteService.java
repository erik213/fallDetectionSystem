package com.br.fallDetectionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.model.PacienteCuidadorId;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteCuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteRepository;

@Service
public class PacienteService {

	private PacienteRepository pacienteRepository;
	
	private PacienteCuidadorRepository pacienteCuidadorRepository;
	
	private CuidadorRepository cuidadorRepository;
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
    @Autowired
	public PacienteService(PacienteRepository pacienteRepository, 
						   CuidadorRepository cuidadorRepository,
						   PacienteCuidadorRepository pacienteCuidadorRepository
						   ) {
        this.pacienteRepository = pacienteRepository;
        this.cuidadorRepository = cuidadorRepository;
        this.pacienteCuidadorRepository = pacienteCuidadorRepository;
    }

    public Paciente findPatientById(int id) {
        return pacienteRepository.findById(id);
    }
    
    public Paciente savePaciente(Paciente paciente) {   	
        return pacienteRepository.save(paciente);
    } 
    
    public void associatePacienteCuidador(Paciente paciente, String username) {
    	Cuidador cuidador = cuidadorRepository.findByUsername(username);	
	    Long cuidador_id = (long) cuidador.getId_cuidador();
	    Long paciente_id = (long) paciente.getId_paciente();   	
    	pacienteCuidadorRepository.save(new PacienteCuidador(new PacienteCuidadorId(paciente_id, cuidador_id)));
    }
}
