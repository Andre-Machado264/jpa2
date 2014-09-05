package br.com.caelum.financas.teste;

import javax.persistence.*;

import br.com.caelum.financas.infra.*;
import br.com.caelum.financas.modelo.*;
import br.com.caelum.financas.dao.*;

public class TestaAlteraConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(3);
		conta.setTitular("Andre Machado");
		
		em.getTransaction().commit();
		em.close();
		
	}

}
