package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cuidador")
public class Cuidador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_cuidador")
	private int cod_cuidador;
	
	@Column(name="username")
	private String username;
	
	@Column(name="nome_cuidador")
	private String nome_cuidador;
	
	@Column(name="email_cuidador")
	private String email_cuidador;
	
	@Column(name="telefone_cuidador")
	private String telefone_cuidador;
	
	@Column(name="endereco_cuidador")
	private String endereco_cuidador;
	
	@Column(name="role")
	private Boolean role;
	
	@Column(name="password")
	private String password;
	
}
