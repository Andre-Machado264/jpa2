package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import java.util.*;
import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaListagemContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		em.getTransaction().begin();
		List<Conta> lista = dao.listaContaComGerente();
		
		for (Conta conta : lista){
			System.out.println(conta.getTitular());
			if(conta.getGerente() != null)
				System.out.println("Gerente: " +conta.getGerente().getNome());
//			if(conta.getMovimentacoes() != null)
//				System.out.println(conta.getMovimentacoes().size());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
