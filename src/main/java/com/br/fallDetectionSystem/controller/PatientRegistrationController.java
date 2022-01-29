package com.br.fallDetectionSystem.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.service.PacienteService;

@Controller
public class PatientRegistrationController {

	@Autowired
	private PacienteService pacienteService;
	
    @RequestMapping(value="/register-patient", method = RequestMethod.GET)
    public ModelAndView registerPatient(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("paciente", new Paciente());
        modelAndView.setViewName("register-patient");
        return modelAndView;
    }
    
    @RequestMapping(value = "/register-patient", method = RequestMethod.POST)
    public ModelAndView createPatient(Paciente paciente, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
       
        pacienteService.savePaciente(paciente);
        pacienteService.associatePacienteCuidador(paciente, getCurrentCuidador());
        
        modelAndView.addObject("successMessage", "Patient has been registered successfully");
        modelAndView.addObject("paciente", new Paciente());
        modelAndView.setViewName("register-patient");
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

