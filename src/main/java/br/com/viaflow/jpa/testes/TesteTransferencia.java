package br.com.viaflow.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.SaldoInsuficienteException;

public class TesteTransferencia {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) throws Exception {

		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 5464", Account.class);
		Account accountOrigin = query.getSingleResult();

		TypedQuery<Account> query2 = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 4789", Account.class);
		Account accountDestiny = query2.getSingleResult();

		System.out.println("Saldo conta 1: " + accountOrigin.getSaldo());
		System.out.println("Saldo conta 2: " + accountDestiny.getSaldo());

		if (accountOrigin != null && accountDestiny != null) {
			entityManager.getTransaction().begin();
			try {
				accountOrigin.transfere(100, accountDestiny);
				System.out.println("Novo saldo conta 1: " + accountOrigin.getSaldo());
				System.out.println("Novo saldo conta 2: " + accountDestiny.getSaldo());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

			entityManager.persist(accountOrigin);
			entityManager.persist(accountDestiny);
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}
}
