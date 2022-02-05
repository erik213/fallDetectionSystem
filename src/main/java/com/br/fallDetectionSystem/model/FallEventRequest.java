package com.br.fallDetectionSystem.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FallEventRequest {

	@NotNull
	@NotBlank
	private int id_camera;
	
	@NotNull
	@NotBlank
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime data_hora;

	public int getId_camera() {
		return id_camera;
	}

	public void setId_camera(int id_camera) {
		this.id_camera = id_camera;
	}

	public LocalDateTime getData_hora() {
		return data_hora;
	}

	public void setData_hora(LocalDateTime data_hora) {
		this.data_hora = data_hora;
	}
}
