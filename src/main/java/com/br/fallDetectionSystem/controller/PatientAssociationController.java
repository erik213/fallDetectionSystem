package com.br.fallDetectionSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.model.PacienteCuidadorId;
import com.br.fallDetectionSystem.repository.PacienteCuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteRepository;
import com.br.fallDetectionSystem.service.PacienteCuidadorService;

@Controller
public class PatientAssociationController {

	@Autowired
	private PacienteCuidadorService pacienteCuidadorService;
	
	@Autowired
	private PacienteCuidadorRepository pacienteCuidadorRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
    @RequestMapping(value="/associate-patient", method = RequestMethod.GET)
    public ModelAndView registerPatient(){
        ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pacienteCuidadorId", new PacienteCuidadorId());
        modelAndView.setViewName("associate-patient");
        return modelAndView;
    }
    
    @RequestMapping(value = "/associate-patient", method = RequestMethod.POST)
    public ModelAndView createPatient(PacienteCuidadorId id, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        
        Paciente paciente = pacienteRepository.findById(id.getId_paciente().intValue());
        
        if(paciente != null) {
        	pacienteCuidadorService.associatePacienteCuidador(paciente.getId_paciente(), getCurrentCuidador());
        	modelAndView.addObject("successMessage", "Patient has been registered successfully");
            modelAndView.addObject("pacienteCuidador", new PacienteCuidadorId());
        }
  
        modelAndView.setViewName("associate-patient");
        return modelAndView;
    }
    
    public String getCurrentCuidador() {
    	Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        if (auth instanceof UserDetails) {
        	String username = ((UserDetails)auth).getUsername();
        	return username;
        } else {
        	String username = auth.toString();
        	return username;
        }
    }
}
