package br.com.caelum.financas.teste;

import javax.persistence.*;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Jose Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		System.out.println("Conta Gravada com sucesso");
		
		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio));
	}

}
