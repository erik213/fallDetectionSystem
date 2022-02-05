package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="paciente_cuidador")
public class PacienteCuidador{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id_paciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "cuidador_id", referencedColumnName="id_cuidador")
	private Cuidador cuidador;
	
	public PacienteCuidador() {}
	
	public PacienteCuidador(int id_paciente, int id_cuidador) {
		this.paciente = new Paciente();
		this.cuidador = new Cuidador();
		this.paciente.setId_paciente(id_paciente);
		this.cuidador.setId_cuidador(id_cuidador);;
	}
	
	public Paciente getPaciente() {
		return this.paciente;	
	}
	
	public Cuidador getCuidador() {
		return this.cuidador;	
	}
	
}