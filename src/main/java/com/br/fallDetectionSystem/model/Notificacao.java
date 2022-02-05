package com.br.fallDetectionSystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="notificacao")
public class Notificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_notificacao")
	private int id_notificacao;
	
	@Column(name="id_evento_queda")
	private int id_evento_queda;
	
	@Column(name="id_cuidador")
	private int id_cuidador;
	
	@Column(name="data_hora")
	private LocalDateTime data_hora;
	
	@Column(name="status")
	private String status;
	
}
