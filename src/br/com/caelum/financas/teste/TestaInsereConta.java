package br.com.caelum.financas.teste;

import javax.persistence.*;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.dao.*;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Andre Machado");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0998");
		
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		entityManager.getTransaction().begin();
		contaDAO.adiciona(conta);
		entityManager.getTransaction().commit();
		System.out.println("Conta Gravada com sucesso");
		
		/*entityManager.getTransaction().begin();
		conta.setTitular("Jose Ribeiro");
		entityManager.getTransaction().commit();
		*/
		
		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio));
	}

}
