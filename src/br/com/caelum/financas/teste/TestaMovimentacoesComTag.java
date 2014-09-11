package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaMovimentacoesComTag {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		TagDAO tagDao = new TagDAO(entityManager);
//		tagDao.adicionaOuBuscaTagComNome("Agencia");
		
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		Conta conta = new Conta();
		
		conta.setTitular("Dehon Tratores");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("99999-9");
		conta.setAgencia("0999");
		contaDAO.adiciona(conta);
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(entityManager);
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setDescricao("Dinheiro Eleicao - setembro/2014");
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("1200"));
		movimentacao.setTag(tagDao.adicionaOuBuscaTagComNome("Teste"));

		movimentacao.setTag(tagDao.adicionaOuBuscaTagComNome("Agencia"));
		movimentacaoDao.adiciona(movimentacao);
		
		
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Conta Gravada com sucesso");
	}

}
