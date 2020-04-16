package br.com.viaflow.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.AccountType;
import br.com.viaflow.jpa.model.Client;
	
public class TesteConta {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		
		Client client = new Client();
		client.setName("Joaquim");
		client.setAddress("Rua Vue, 5247");
		
		Account account = new Account();
		account.setClient(client);
		account.setAgency(1234);
		account.setAccountNumber(4789);
		account.setAccountType(AccountType.Corrente);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		System.out.println("Cliente: " + account.getClient());
	}
		

}
