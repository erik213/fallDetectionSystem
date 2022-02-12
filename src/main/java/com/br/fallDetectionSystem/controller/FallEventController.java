package com.br.fallDetectionSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.fallDetectionSystem.model.EventoQueda;
import com.br.fallDetectionSystem.model.FallEventRequest;
import com.br.fallDetectionSystem.model.MessageResponse;
import com.br.fallDetectionSystem.service.FallEventService;

@Controller
public class FallEventController {

	@Autowired
	private FallEventService fallEventService;
	
	@PostMapping("/new-event")
	public ResponseEntity<MessageResponse> newEvent(@RequestBody FallEventRequest payload){
		MessageResponse messageResponse = fallEventService.registerEvent(payload);
		return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
	};
	
	@RequestMapping(value="/get-patient-history", method = RequestMethod.GET)
    public ModelAndView getPatientHistory(@RequestParam("id_paciente") int id_paciente){
        ModelAndView modelAndView = new ModelAndView();
        List <EventoQueda> eventoQueda = fallEventService.getEventByIdPaciente(id_paciente);
        modelAndView.addObject("eventoQueda", eventoQueda);
        modelAndView.setViewName("patient-history");
        return modelAndView;
    }
}
