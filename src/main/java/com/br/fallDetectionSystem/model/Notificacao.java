package com.br.fallDetectionSystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notificacao {

	@Id
	private int cod_notificacao;
	
	private int cod_evento_queda;
	
	private int cod_cuidador;
	
	private Date data_hora;
	
	private String status;

	public int getCod_notificacao() {
		return cod_notificacao;
	}

	public void setCod_notificacao(int cod_notificacao) {
		this.cod_notificacao = cod_notificacao;
	}

	public int getCod_evento_queda() {
		return cod_evento_queda;
	}

	public void setCod_evento_queda(int cod_evento_queda) {
		this.cod_evento_queda = cod_evento_queda;
	}

	public int getCod_cuidador() {
		return cod_cuidador;
	}

	public void setCod_cuidador(int cod_cuidador) {
		this.cod_cuidador = cod_cuidador;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
