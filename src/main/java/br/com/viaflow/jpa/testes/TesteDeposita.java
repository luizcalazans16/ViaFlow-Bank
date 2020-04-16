package br.com.viaflow.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Account;

public class TesteDeposita {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 5464", Account.class);
		Account account = query.getSingleResult();

		System.out.println("Saldo atual: " + account.getSaldo());
		if (account != null) {
			entityManager.getTransaction().begin();
			try {
				account.deposita(200);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			System.out.println("Novo saldo: " + account.getSaldo());
			entityManager.persist(account);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
}
