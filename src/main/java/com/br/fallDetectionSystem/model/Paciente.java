package com.br.fallDetectionSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_paciente")
	private int id_paciente;
	
	@Column(name = "nome_paciente")
	private String nome;
	
	@Column(name = "aniversario")
	private Date aniversario;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "genero")
	private String genero;
}
