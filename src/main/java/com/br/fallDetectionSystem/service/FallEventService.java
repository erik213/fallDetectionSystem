package com.br.fallDetectionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.EventoQueda;
import com.br.fallDetectionSystem.model.FallEventRequest;
import com.br.fallDetectionSystem.model.MessageResponse;
import com.br.fallDetectionSystem.repository.EventoQuedaRepository;

@Service
public class FallEventService {
	
	@Autowired
	private EventoQuedaRepository eventoQuedaRepository;
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	public MessageResponse registerEvent(FallEventRequest eventRequest) {
		EventoQueda novoEventoQueda = new EventoQueda();
		MessageResponse messageResponse = new MessageResponse();	
		try {
			novoEventoQueda.setId_camera(eventRequest.getId_camera());
			novoEventoQueda.setData_hora(eventRequest.getData_hora());
			eventoQuedaRepository.save(novoEventoQueda);
			messageResponse.setMessage("Event registred successfully");
			
			notificacaoService.sendNotification(novoEventoQueda);
		} catch (Exception ex){
			messageResponse.setMessage("Failed to register event");
		}
		return messageResponse;
	};
	
}
