package br.com.viaflow.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Client;

public class TesteCriaTabelas {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
//		Client client = entityManager.find(Client.class, 1L);
//		System.out.println("Nome do cliente:" + client.getName());
		
		TypedQuery<Client> query =
			      entityManager.createQuery("SELECT c FROM Client c", Client.class);
		//System.out.println(query);
		
		List<Client> results = query.getResultList();
		
		for (Client client : results) {
			System.out.println(client.getName());
		}
//		Client client = new Client();
//		client.setName("João");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(client);
//		entityManager.getTransaction().commit();
		
//		Client client = entityManager.find(Client.class, 2);
//		entityManager.getTransaction().begin();
//		entityManager.remove(client);
//		entityManager.getTransaction().commit();
		
//		Client client = new Client();
//		client.setId(29L);
//		client.setName("Gabriel");
//		entityManager.getTransaction().begin();
//		entityManager.merge(client);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		entityManagerFactory.close();
		
		
		
	
		
		
		
		
	}

}
