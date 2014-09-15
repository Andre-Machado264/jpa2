package br.com.caelum.financas.modelo;

import javax.persistence.*;

@Entity
public class Gerente {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	private String telefone;
	
	@Embedded
	public Endereco endereco = new Endereco();
	
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

}
