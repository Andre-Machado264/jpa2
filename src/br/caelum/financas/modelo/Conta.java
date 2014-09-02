package br.caelum.financas.modelo;

import javax.persistence.*;

@Entity
public class Conta {

	@Id
	private Integer id;
	
	private String titular;
	private String agencia;
	private String numero;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
