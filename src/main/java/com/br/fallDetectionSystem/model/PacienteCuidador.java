package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@Column(name="id_paciente")
	private int id_paciente;
	
	@Column(name="id_cuidador")
	private int id_cuidador;
	
	@OneToOne
	@JoinColumn(name = "nomePaciente", referencedColumnName = "nome_paciente")
	private String nomePaciente;
	
	@OneToOne
	@JoinColumn(name = "nomeCuidador", referencedColumnName = "nome_cuidador")
	private String nomeCuidador;
	
	public PacienteCuidador() {}
	
	public PacienteCuidador(int id_paciente, int id_cuidador) {
		this.id_paciente = id_paciente;
		this.id_cuidador = id_cuidador;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public void setNomeCuidador(String nomeCuidador) {
		this.nomePaciente = nomeCuidador;
	}
	
	public String getNomePaciente() {
		return this.nomePaciente;
	}
	
	public String getetNomeCuidador() {
		return this.nomePaciente = nomeCuidador;
	}
}