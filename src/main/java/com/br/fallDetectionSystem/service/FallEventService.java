package com.br.fallDetectionSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.model.EventoQueda;
import com.br.fallDetectionSystem.model.FallEventRequest;
import com.br.fallDetectionSystem.model.MessageResponse;
import com.br.fallDetectionSystem.repository.CameraRepository;
import com.br.fallDetectionSystem.repository.EventoQuedaRepository;

@Service
public class FallEventService {
	
	@Autowired
	private EventoQuedaRepository eventoQuedaRepository;
	
	@Autowired
	private NotificacaoService notificacaoService;
	
	@Autowired
	private CameraRepository cameraRepository;
	
	public MessageResponse registerEvent(FallEventRequest eventRequest) {
		EventoQueda novoEventoQueda = new EventoQueda();
		MessageResponse messageResponse = new MessageResponse();	
		try {
			novoEventoQueda.setCamera(cameraRepository.findById(eventRequest.getId_camera()));
			novoEventoQueda.setData_hora(eventRequest.getData_hora());
			novoEventoQueda.setPaciente(cameraRepository.findById(eventRequest.getId_camera()).getPaciente());
			eventoQuedaRepository.save(novoEventoQueda);
			messageResponse.setMessage("Event registred successfully");
			
			notificacaoService.sendNotification(novoEventoQueda);
		} catch (Exception ex){
			messageResponse.setMessage("Failed to register event");
		}
		return messageResponse;
	};
	
	public List<EventoQueda> getEventByIdPaciente(int id_paciente) {
		List <EventoQueda> event = eventoQuedaRepository.findQuedaByPacienteId(id_paciente);
		return event;
	}
	
}
