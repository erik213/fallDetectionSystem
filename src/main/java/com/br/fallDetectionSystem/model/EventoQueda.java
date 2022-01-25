package com.br.fallDetectionSystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventoQueda {
	
	@Id
	private int cod_evento_queda;
	
	private int cod_camera;
	
	private Date data_hora;

	public int getCod_evento_queda() {
		return cod_evento_queda;
	}

	public void setCod_evento_queda(int cod_evento_queda) {
		this.cod_evento_queda = cod_evento_queda;
	}

	public int getCod_camera() {
		return cod_camera;
	}

	public void setCod_camera(int cod_camera) {
		this.cod_camera = cod_camera;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	
}
