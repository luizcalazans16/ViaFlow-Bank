package br.com.viaflow.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Client;
import br.com.viaflow.jpa.model.Transaction;

public class SelectTransactions {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		TypedQuery<Transaction> query = entityManager
				.createQuery("SELECT t FROM Transaction t  WHERE account_id = 2", Transaction.class);
		List<Transaction> results = query.getResultList();

		for (Transaction transaction : results) {
			System.out.println("Nome: " + transaction.getDescricao());
			System.out.println(transaction.getData());
			System.out.println(transaction.getId());
			System.out.println(transaction.getTransactionType());
			System.out.println(transaction.getValor());
		}

	}

}
