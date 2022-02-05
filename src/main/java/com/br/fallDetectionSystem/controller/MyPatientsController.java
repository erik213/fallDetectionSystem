package com.br.fallDetectionSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.service.PacienteCuidadorService;

@Controller
public class MyPatientsController {

	@Autowired
	private PacienteCuidadorService pacienteCuidadorService;
	
	@Autowired
	private CuidadorRepository cuidadorRepository;
	
	@RequestMapping(value="/my-patients", method=RequestMethod.GET)
	public ModelAndView myPatients() {
		ModelAndView modelAndView = new ModelAndView();
		List <PacienteCuidador> pacienteCuidadorList = pacienteCuidadorService.findPacienteCuidador(getCurrentCuidadorId());
//		for (PacienteCuidador pacienteCuidador : pacienteCuidadorList) {
//			pacienteCuidador.setNomePaciente(pacienteRepository.findById(pacienteCuidador.getId_paciente()).getNome());
//			pacienteCuidador.setNomeCuidador(cuidadorRepository.findById(getCurrentCuidadorId()).getNome());
//		}
		//modelAndView.addObject("pacienteCuidador", pacienteCuidadorService.findPacienteCuidador(getCurrentCuidadorId()));
		modelAndView.addObject("pacienteCuidador", pacienteCuidadorList);
		modelAndView.setViewName("my-patients");
		return modelAndView;
	}
	
	public int getCurrentCuidadorId() {
    	Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    	String username = null;
    	if (auth instanceof UserDetails) {
        	username = ((UserDetails)auth).getUsername();
        } else {
        	username = auth.toString();
        }
        Cuidador cuidador = cuidadorRepository.findByUsername(username);	
	    int cuidador_id = cuidador.getId_cuidador();
	    return cuidador_id;
    }
	
}
