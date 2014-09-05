package br.com.caelum.financas.dao;

import javax.persistence.*;

public class DAO<T> {
	
	private final EntityManager em;
	private final Class<T> classe;
	
	public DAO (EntityManager em, Class<T> classe){
		this.em = em;
		this.classe = classe;
	}

}
