package com.br.fallDetectionSystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EventoQueda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_evento_queda")
	private int id_evento_queda;
	
	@Column(name="id_camera")
	private int id_camera;
	
	@Column(name="data_hora")
	private LocalDateTime data_hora;
	
}
