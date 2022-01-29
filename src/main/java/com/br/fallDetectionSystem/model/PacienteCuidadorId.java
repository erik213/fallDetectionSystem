package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@SuppressWarnings("serial")
@Embeddable
public class PacienteCuidadorId implements Serializable {

	@Column(name = "id_paciente")
    private Long id_paciente;

    @Column(name = "id_cuidador")
    private Long id_cuidador;
    
    public PacienteCuidadorId() {
    	
    }
    
    public PacienteCuidadorId(Long id_paciente, Long id_cuidador) {
        this.id_paciente = id_paciente;
        this.id_cuidador = id_cuidador;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteCuidadorId that = (PacienteCuidadorId) o;
        return id_paciente.equals(that.id_paciente) &&
        		id_cuidador.equals(that.id_cuidador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_paciente, id_cuidador);
    }
}
