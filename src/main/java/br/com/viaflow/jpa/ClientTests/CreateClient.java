package br.com.viaflow.jpa.ClientTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Client;
import br.com.viaflow.jpa.model.ClientGender;

public class CreateClient {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		Client client = new Client();
		client.setName("Rafael Kempfer");
		client.setAddress("Rua Java, 8");
		client.setCpf("06206485230");
		client.setEmail("rafael@viaflow.com.br");
		client.setClientGender(ClientGender.Masculino);
		client.setPhone("38559320");
		
		Client client2 = new Client();
		client.setName("Dayanna");
		client.setAddress("Rua Vue, 89");
		client.setCpf("06706589031");
		client.setEmail("dayanna@viaflow.com.br");
		client.setClientGender(ClientGender.Feminino);
		client.setPhone("32045820");
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}
	
	
}
