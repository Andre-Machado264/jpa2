package br.com.caelum.financas.infra;

import javax.persistence.*;

public class JPAUtil {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controlefinancas");
	
	public EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
}
