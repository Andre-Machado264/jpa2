package br.com.caelum.financas.modelo;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.*;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	private Calendar data;
	private BigDecimal valor;
	
	@ManyToOne
	private Conta conta;
	
	@ManyToMany
	private List<Tag> tags = new ArrayList<Tag>();
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void setTag(Tag tag){
		tags.add(tag);
	}

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
