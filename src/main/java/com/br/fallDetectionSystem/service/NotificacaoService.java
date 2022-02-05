package com.br.fallDetectionSystem.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fallDetectionSystem.mail.MailService;
import com.br.fallDetectionSystem.model.Camera;
import com.br.fallDetectionSystem.model.Cuidador;
import com.br.fallDetectionSystem.model.EventoQueda;
import com.br.fallDetectionSystem.model.Notificacao;
import com.br.fallDetectionSystem.model.Paciente;
import com.br.fallDetectionSystem.model.PacienteCuidador;
import com.br.fallDetectionSystem.repository.CameraRepository;
import com.br.fallDetectionSystem.repository.NotificacaoRepository;
import com.br.fallDetectionSystem.repository.PacienteCuidadorRepository;
import com.br.fallDetectionSystem.repository.PacienteRepository;

@Service
public class NotificacaoService {

	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	@Autowired
	private PacienteCuidadorRepository pacienteCuidadorRepository;
	
	@Autowired
	private CameraRepository cameraRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MailService mailService;
	
	public void sendNotification(EventoQueda event) {
		
		Camera camera = cameraRepository.findById(event.getId_camera());
		
		Paciente paciente = getPacienteFromCameraId(camera);
		
		List<Cuidador> cuidadorList = getCuidadorToNotify(paciente);
		
		Boolean result = false;
		
		String subject = "Queda detectada!";
		
		String text = "Uma queda do paciente " + paciente.getNome() + " foi detectada pela camera " + camera.getLocalizacao_camera() + " as " + event.getData_hora().toString(); 
		
		for(Cuidador cuidador: cuidadorList) {
			result = mailService.sendMail(cuidador.getEmail(), subject, text);
			
			LocalDateTime dateTime = LocalDateTime.now();
			
			Notificacao notification = new Notificacao();
			notification.setId_evento_queda(event.getId_evento_queda());
			notification.setId_cuidador(cuidador.getId_cuidador());
			notification.setData_hora(dateTime);
			
			if(result == true) {
				notification.setStatus("Enviado");
			}
			else {
				notification.setStatus("Nao enviado");
			}
			
			notificacaoRepository.save(notification);
		}
		
	}
	
	public Paciente getPacienteFromCameraId(Camera camera) {
		Paciente paciente = pacienteRepository.findById(camera.getId_paciente()).get();
		return paciente;
	}
	
	public List<Cuidador> getCuidadorToNotify(Paciente paciente){
		List<PacienteCuidador> pacienteCuidadorList = pacienteCuidadorRepository.findCuidadorByPacienteId(paciente.getId_paciente());
		List<Cuidador> cuidadorList = new ArrayList<Cuidador>();
		for(PacienteCuidador cuidador: pacienteCuidadorList) {
			cuidadorList.add(cuidador.getCuidador());
		}
		return cuidadorList;
	}
}
