package com.br.fallDetectionSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="cuidador")
public class Cuidador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name = "id_cuidador")
	private int id_cuidador;
	
	@NotEmpty(message = "Username não pode estar vazio.")
    @Size(min = 5, max = 45, message = "Username deve conter no mínimo 5 caracteres.")
	@Column(name="username")
	private String username;
	
	@NotEmpty(message = "Nome completo não pode estar vazio.")
	@Size(min = 5, max = 255)
	@Column(name="nome_cuidador")
	private String nome;
	
	@NotEmpty(message = "Email não pode estar vazio.")
	@Column(name="email")
	private String email;
	
	@NotEmpty(message = "Telefone não pode estar vazio.")
	@Column(name="telefone")
	private String telefone;
	
	@NotEmpty(message = "Endereço não pode estar vazio.")
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="role")
	private String role;
	
	@NotEmpty(message = "Senha não pode estar vazio.")
    @Size(min = 5, max = 255, message = "Senha deve conter no mínimo 5 caracteres.")
	@Column(name="password")
	private String password;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
}
