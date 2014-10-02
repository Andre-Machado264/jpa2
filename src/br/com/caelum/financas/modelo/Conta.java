package br.com.caelum.financas.modelo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames="gerente_id")})
public class Conta {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
	
	@OneToOne
	private Gerente gerente;

	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
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
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Integer getId() {
		return id;
	}
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
}
