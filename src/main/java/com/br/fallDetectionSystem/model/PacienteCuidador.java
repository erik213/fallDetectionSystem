package com.br.fallDetectionSystem.model;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="paciente_cuidador")
public class PacienteCuidador implements Serializable{
	
	@EmbeddedId
	private PacienteCuidadorId pacienteCuidadorId;
	
	public PacienteCuidador() {
		
	}
	
	public PacienteCuidador(PacienteCuidadorId pacienteCuidadorId) {
        this.pacienteCuidadorId = pacienteCuidadorId;
    }
}