package com.br.fallDetectionSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.repository.CuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteRepository;
import com.br.fallDetectionSystem.service.PacienteCuidadorService;

@Controller
public class PatientAssociationController {

	@Autowired
	private PacienteCuidadorService pacienteCuidadorService;
	
	@Autowired
	private CuidadorRepository cuidadorRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
    @RequestMapping(value="/associate-patient", method = RequestMethod.GET)
    public ModelAndView registerPatient(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id_cuidador", getCurrentCuidadorId());
		modelAndView.addObject("pacienteCuidador", new PacienteCuidador());
        modelAndView.setViewName("associate-patient");
        return modelAndView;
    }
    
    @RequestMapping(value = "/associate-patient", method = RequestMethod.POST)
    public ModelAndView createPatient(PacienteCuidador id, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Paciente paciente = pacienteRepository.findById(id.getPaciente().getId_paciente());
        
        if(paciente == null) {
        	modelAndView.addObject("warningMessage", "Patient not found");
        	modelAndView.addObject("id_cuidador", getCurrentCuidadorId());
        }
        
        if(paciente != null) {
        	pacienteCuidadorService.associatePacienteCuidador(paciente.getId_paciente(), getCurrentCuidadorLogin());
        	modelAndView.addObject("successMessage", "Patient has been registered successfully");
            modelAndView.addObject("pacienteCuidador", new PacienteCuidador());
        }
  
        modelAndView.setViewName("associate-patient");
        return modelAndView;
    }
    
    public String getCurrentCuidadorLogin() {
    	Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        if (auth instanceof UserDetails) {
        	String username = ((UserDetails)auth).getUsername();
        	return username;
        } else {
        	String username = auth.toString();
        	return username;
        }
    }
    
    public int getCurrentCuidadorId() {
    	Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        if (auth instanceof UserDetails) {
        	String username = ((UserDetails)auth).getUsername();
        	Cuidador cuidador = cuidadorRepository.findByUsername(username);	
    	    int cuidador_id = cuidador.getId_cuidador();
        	return cuidador_id;
        } else {
        	String username = auth.toString();
        	Cuidador cuidador = cuidadorRepository.findByUsername(username);	
    	    int cuidador_id = cuidador.getId_cuidador();
        	return cuidador_id;
        }
    }
}
