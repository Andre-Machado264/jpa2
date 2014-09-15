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
		gerente.setNome("Francisco");
		gerente.setTelefone("38218745");
		gerente.endereco.setRua("JK");
		gerente.endereco.setCidade("Lavras");
		gerente.endereco.setEstado("MG");

		
		entityManager.persist(gerente);
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		Conta conta = new Conta();
		
		conta.setTitular("Jose Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("99999-9");
		conta.setAgencia("999");
		conta.setGerente(gerente);
		contaDAO.adiciona(conta);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Conta Gravada com sucesso");
	}

}
