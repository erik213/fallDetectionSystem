package com.br.fallDetectionSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.service.CuidadorService;

@Controller
public class RegistrationControler {

	@Autowired
	private CuidadorService cuidadorService;

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cuidador", new Cuidador());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(Cuidador cuidador, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Cuidador userExists = cuidadorService.findUserByUserName(cuidador.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "Já existe um usuário com este nome!");
        }
        if (bindingResult.hasErrors()) {        	
        	modelAndView.setViewName("registration");
        } else {
            cuidadorService.saveCuidador(cuidador);
            modelAndView.addObject("successMessage", "Usuário cadastrado com suceso!");
            modelAndView.addObject("user", new Cuidador());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
}
