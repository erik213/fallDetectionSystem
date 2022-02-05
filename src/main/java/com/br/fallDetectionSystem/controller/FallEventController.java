package com.br.fallDetectionSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
