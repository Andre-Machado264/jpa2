package br.com.caelum.financas.dao;

import javax.persistence.*;

import java.util.*;

import br.com.caelum.financas.modelo.Conta;

public class ContaDAO{
	private final DAO<Conta> dao;
	
	public ContaDAO(EntityManager em){
//		super(em, Conta.class);
		dao = new DAO<Conta>(em, Conta.class);
	}
	
	public void adiciona(Conta conta){
		dao.adiciona(conta);
	}
	
	public Conta busca(Integer id){
		return dao.busca(id);
	}
	
	public List<Conta> lista(){
		return dao.lista();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listaContaComGerente(){
		return dao.em.createQuery("Select e from "+ Conta.class.getName() + " e left outer join fetch e.gerente ").getResultList();
	}
	
	public void remove(Conta conta){
		dao.remove(conta);
	}
		
}
