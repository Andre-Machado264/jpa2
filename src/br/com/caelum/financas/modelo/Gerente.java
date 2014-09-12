package br.com.caelum.financas.modelo;

import javax.persistence.*;

@Entity
public class Gerente {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	private String telefone;
	
	private String rua;
	private String cidades;
	private String estado;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCidades() {
		return cidades;
	}

	public void setCidades(String cidades) {
		this.cidades = cidades;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
