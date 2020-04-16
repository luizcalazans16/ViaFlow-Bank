package br.com.viaflow.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.AccountType;
import br.com.viaflow.jpa.model.Client;
import br.com.viaflow.jpa.model.ClientGender;
	
public class TesteConta {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		
		Client client = new Client();
		client.setName("João");
		client.setAddress("Rua SQL, 5247");
		client.setClientGender(ClientGender.Masculino);
		client.setCpf("063.054.890-55");
		client.setEmail("joao.1234@outlook.com.br");
		client.setPhone("51982653020");
		
		Account account = new Account();
		account.setClient(client);
		account.setAgency(1234);
		account.setAccountNumber(4789);
		account.setAccountType(AccountType.Poupanca);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		System.out.println("Cliente: " + account.getClient());
	}
		

}
