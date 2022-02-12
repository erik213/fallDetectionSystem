package com.br.fallDetectionSystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class EventoQueda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_evento_queda")
	private int id_evento_queda;
	
	@ManyToOne
	@JoinColumn(name = "camera_id", referencedColumnName="id_camera")
	private Camera camera;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id_paciente")
	private Paciente paciente;
	
	@Column(name="data_hora")
	private LocalDateTime data_hora;
	
	public EventoQueda() {
		
	}
	
	public EventoQueda(int camera_id) {
		this.camera = new Camera();
		this.camera.setId_camera(camera_id);
	}
	
	public Camera getCamera() {
		return this.camera;
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
