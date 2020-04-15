package br.com.viaflow.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Client;

public class SelectClients {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {

		TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
		// System.out.println(query);

		List<Client> results = query.getResultList();

		for (Client client : results) {
			System.out.print("Nome: " + client.getName() + " | " );
			System.out.print(" " + "Endereço: " + client.getAddress());
		}

	}
}
