package com.br.fallDetectionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;

@Service
public class CuidadorService {

	private CuidadorRepository cuidadorRepository;
	
    @Autowired
	public CuidadorService(CuidadorRepository cuidadorRepository) {
        this.cuidadorRepository = cuidadorRepository;
    }

    public Cuidador findUserByUserName(String username) {
        return cuidadorRepository.findByUsername(username);
    }
    
    public Cuidador saveCuidador(Cuidador cuidador) {
    	cuidador.setPassword(passwordEncoder().encode(cuidador.getPassword()));
    	cuidador.setEnabled(true);
    	cuidador.setRole("ROLE_USER");
        return cuidadorRepository.save(cuidador);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}