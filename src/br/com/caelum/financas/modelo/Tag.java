package br.com.caelum.financas.modelo;

import javax.persistence.*;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
