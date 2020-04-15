package br.com.viaflow.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.viaflow.jpa.model.Client;
import br.com.viaflow.jpa.model.ClientGender;

public class TesteCriaCliente {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		Client client = new Client();
		client.setName("Matheus");
		client.setCpf("45689753160");
		client.setEmail("matheus.123@gmail.com");
		client.setClientGender(ClientGender.Masculino);
		client.setPhone("30559650");
		client.setAddress("Rua Dinamarca, 555");
		
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Nome do cliente: " + client.getName());
		System.out.println("Endereço: " + client.getAddress());
		System.out.println("Telefone: " + client.getPhone());
		System.out.println("E-mail: " + client.getEmail());
		
	}

}
