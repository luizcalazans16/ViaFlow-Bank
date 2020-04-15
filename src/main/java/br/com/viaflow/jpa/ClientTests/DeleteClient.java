package br.com.viaflow.jpa.ClientTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.Client;

public class DeleteClient {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		Account account = entityManager.find(Account.class, 1L);
		entityManager.getTransaction().begin();
		entityManager.remove(account);
		entityManager.getTransaction().commit();
		
	}

}
