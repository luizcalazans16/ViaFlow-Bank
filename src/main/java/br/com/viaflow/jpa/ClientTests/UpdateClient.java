package br.com.viaflow.jpa.ClientTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Client;
import br.com.viaflow.jpa.model.ClientGender;

public class UpdateClient {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		

		Client client = new Client();
		client.setId(5L);
		client.setAddress("Rua Vue, 1100");
		client.setName("Marcos");
		//client.setCpf("06206496589");
		//client.setClientGender(ClientGender.Masculino);
		//client.setEmail("luizfernando.calazans8@gmail.com");
		//client.setPhone("30513921");
//		System.out.println("Nome atual: " + client.getName());
//		System.out.println("Telefone atual: " + client.getPhone());
//		client.setName("Luiz Fernando Calazans");
//		client.setPhone("98267807");
//		System.out.println("----------------------");
//		System.out.println(" ");
//		System.out.println("Novo nome: " + client.getName());
//		System.out.println("Novo telefone: " + client.getPhone());
		
		entityManager.getTransaction().begin();
		
		entityManager.merge(client);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}
}
