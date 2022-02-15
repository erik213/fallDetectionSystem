package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuidador")
public class Cuidador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "id_cuidador")
	private int id_cuidador;
	
	@Column(name="username")
	private String username;
	
	@Column(name="nome_cuidador")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
}
