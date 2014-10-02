package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscaContaDaMovimentacao {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(7);
		
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		em.getTransaction().begin();
		List<Movimentacao> encontrado = movimentacaoDao.listaTodasMovimentacoesPorNome("brádesco");
		for(Movimentacao i: encontrado){
			System.out.println(i.getValor());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}

}
