package br.com.caelum.financas.teste;

//import java.util.Date;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.*;

//import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaMovimentacao {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Maria");
		conta.setBanco("Banco Santander");
		conta.setNumero("99999-9");
		conta.setAgencia("999");
		entityManager.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setDescricao("Conta de luz - setembro/2014");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("54"));
		
//		ContaDAO contaDAO = new ContaDAO(entityManager);
		
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Conta Gravada com sucesso");
	}

}
