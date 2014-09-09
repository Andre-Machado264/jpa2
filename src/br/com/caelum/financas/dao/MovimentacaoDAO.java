package br.com.caelum.financas.dao;

import javax.persistence.*;
import java.util.*;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {
	private final DAO<Movimentacao> dao;
	
	public MovimentacaoDAO(EntityManager em){
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
}
