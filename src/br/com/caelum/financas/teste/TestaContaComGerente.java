package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Gerente;


public class TestaContaComGerente {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Gerente gerente = new Gerente();
		gerente.setNome("Alfredo");
		gerente.setTelefone("38211158");
		gerente.setCidades("Lavras");
		gerente.setEstado("MG");
		gerente.setRua("Francisco de Andrade");
		
		entityManager.persist(gerente);
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		Conta conta = new Conta();
		
		conta.setTitular("Jose Francisco");
		conta.setBanco("Banco Bradesco");
		conta.setNumero("88888-8");
		conta.setAgencia("888");
		conta.setGerente(gerente);
		contaDAO.adiciona(conta);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Conta Gravada com sucesso");
	}

}
