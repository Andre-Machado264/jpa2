package br.com.caelum.financas.teste;

//import java.util.Date;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.*;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
//import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		Conta conta = new Conta();
		
		conta.setTitular("Jose Francisco");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("88888-8");
		conta.setAgencia("888");
		contaDAO.adiciona(conta);
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(entityManager);
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setDescricao("Conta de Luz - setembro/2014");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("50"));
		movimentacaoDao.adiciona(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Conta Gravada com sucesso");
	}

}
