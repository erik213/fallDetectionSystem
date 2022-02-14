package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="camera")
public class Camera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_camera")
	private Integer id_camera;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id", referencedColumnName="id_paciente")
	private Paciente paciente;
	
	@Column(name="localizacao_camera")
	private String localizacao_camera;
	
	public Camera(int id_paciente) {
		this.paciente = new Paciente();
		this.paciente.setId_paciente(id_paciente);
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
}
