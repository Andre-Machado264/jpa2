package br.caelum.financas.teste;

import javax.persistence.*;
import br.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Jpse Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		System.out.println("Conta Gravado com sucesso");
	}

}
