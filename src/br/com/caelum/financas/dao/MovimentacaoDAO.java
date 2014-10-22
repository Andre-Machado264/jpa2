package br.com.caelum.financas.dao;

import javax.persistence.*;

import java.util.*;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {
	private final DAO<Movimentacao> dao;
	private final EntityManager em;
	
	public MovimentacaoDAO(EntityManager em){
		this.em = em;
		dao = new DAO<Movimentacao>(em, Movimentacao.class);
	}
	
	public void adiciona(Movimentacao t){
		dao.adiciona(t);
	}
	
	public Movimentacao busca(Integer id){
		return dao.busca(id);
	}
	
	public List<Movimentacao> lista(){
		return dao.lista();
	}
	
	public void remove(Movimentacao Movimentacao){
		dao.remove(Movimentacao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimentacao> listaTodasMovimentacoes(Conta conta){
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		Query query = this.em.createQuery(jpql);
		query.setParameter("pConta", conta);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimentacao> listaTodasMovimentacoesPorNome(String nome){
		
		String jpql = "select m from Movimentacao m where m.conta.banco like :nomeBanco";
		Query query = this.em.createQuery(jpql);
		query.setParameter("nomeBanco", "%"+nome+"%");
		
		return query.getResultList();
	}
}
