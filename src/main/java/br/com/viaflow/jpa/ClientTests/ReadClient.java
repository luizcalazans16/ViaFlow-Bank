package br.com.viaflow.jpa.ClientTests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Client;

public class ReadClient {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		
		TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
		// System.out.println(query);

		List<Client> results = query.getResultList();

		for (Client client : results) {
			System.out.println("--------------------------------------------");
			System.out.println(" | " + "Nome: " + client.getName() + " | " );
			System.out.println(" | " + "CPF: " + client.getCpf()+ " | ");
			System.out.println(" | " + "Gênero: " + client.getClientGender() + " | ");
			System.out.println(" | " + "Endereço: " + client.getAddress() + " | " );
			System.out.println(" | " + "E-mail: " + client.getEmail() + " | ");
			System.out.println(" | " + "Telefone: " + client.getPhone() + " | ");
		}
		
		
		
		TypedQuery<Client> query2 = entityManager.createQuery("SELECT cli FROM Client cli "
				+ "WHERE cli.email like 'viaflow'", Client.class);
		
		List<Client> results2 = query2.getResultList();
		
		for(Client client : results2) {
			System.out.println("--------------------------------------------");
			System.out.println(" | " + "Nome: " + client.getName() + " | " );
			System.out.println(" | " + "CPF: " + client.getCpf()+ " | ");
			System.out.println(" | " + "Gênero: " + client.getClientGender() + " | ");
			System.out.println(" | " + "Endereço: " + client.getAddress() + " | " );
			System.out.println(" | " + "E-mail: " + client.getEmail() + " | ");
			System.out.println(" | " + "Telefone: " + client.getPhone() + " | ");
		}
		
	}
}
