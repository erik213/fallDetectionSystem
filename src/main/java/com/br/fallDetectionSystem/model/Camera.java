package com.br.fallDetectionSystem.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camera {

	@Id
	private int cod_camera;
	
	private int cod_paciente;
	
	private String localizacao_camera;
	
	private int online;
	
	private Date last_online_status;

	public int getCod_camera() {
		return cod_camera;
	}

	public void setCod_camera(int cod_camera) {
		this.cod_camera = cod_camera;
	}

	public int getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(int cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public String getLocalizacao_camera() {
		return localizacao_camera;
	}

	public void setLocalizacao_camera(String localizacao_camera) {
		this.localizacao_camera = localizacao_camera;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public Date getLast_online_status() {
		return last_online_status;
	}

	public void setLast_online_status(Date last_online_status) {
		this.last_online_status = last_online_status;
	}
}
