package br.com.caelum.financas.teste;

import javax.persistence.*;

import br.com.caelum.financas.infra.*;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.dao.*;

public class TestaRemoveConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(2);
		dao.remove(conta);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
