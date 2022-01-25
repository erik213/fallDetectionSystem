package com.br.fallDetectionSystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente {

	@Id
	private int cod_paciente;
	
	private String nome_paciente;
	
	private String genero_paciente;
	
	private Date aniversario_paciente;
	
	private String endereco_paciente;
	
	private int telefone_paciente;
	
	public int getCod_paciente() {
		return cod_paciente;
	}
	public void setCod_paciente(int cod_paciente) {
		this.cod_paciente = cod_paciente;
	}
	public String getNome_paciente() {
		return nome_paciente;
	}
	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	public String getGenero_paciente() {
		return genero_paciente;
	}
	public void setGenero_paciente(String genero_paciente) {
		this.genero_paciente = genero_paciente;
	}
	public Date getAniversario_paciente() {
		return aniversario_paciente;
	}
	public void setAniversario_paciente(Date aniversario_paciente) {
		this.aniversario_paciente = aniversario_paciente;
	}
	public String getEndereco_paciente() {
		return endereco_paciente;
	}
	public void setEndereco_paciente(String endereco_paciente) {
		this.endereco_paciente = endereco_paciente;
	}
	public int getTelefone_paciente() {
		return telefone_paciente;
	}
	public void setTelefone_paciente(int telefone_paciente) {
		this.telefone_paciente = telefone_paciente;
	}
}
