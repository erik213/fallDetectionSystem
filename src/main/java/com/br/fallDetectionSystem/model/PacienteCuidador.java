package com.br.fallDetectionSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PacienteCuidador {

	@Id
	private int cod_paciente;
	private int cod_cuidador;
	
	public int getCod_paciente() {
		return cod_paciente;
	}
	public void setCod_paciente(int cod_paciente) {
		this.cod_paciente = cod_paciente;
	}
	public int getCod_cuidador() {
		return cod_cuidador;
	}
	public void setCod_cuidador(int cod_cuidador) {
		this.cod_cuidador = cod_cuidador;
	}
}
