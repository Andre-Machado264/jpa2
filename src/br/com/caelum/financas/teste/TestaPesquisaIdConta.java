package br.com.caelum.financas.teste;

import javax.persistence.*;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaPesquisaIdConta {
	public static void main(String[] args){
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		em.getTransaction().begin();
		Conta encontrado = dao.busca(4);
		System.out.println(encontrado.getTitular());
		
		em.getTransaction().commit();
		em.close();
			
		
	}
}
