package br.com.viaflow.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.Transaction;
import br.com.viaflow.jpa.model.TransactionType;

public class TesteDeposita {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 5464", Account.class);
		Account account = query.getSingleResult();
		
		Transaction transaction = new Transaction();

		System.out.println("Saldo atual: " + account.getSaldo());
		if (account != null) {
			entityManager.getTransaction().begin();
			try {
				account.deposita(200);
				transaction.setDescricao("Depósito");
				transaction.setTransactionType(TransactionType.Credito);
				transaction.setData(LocalDateTime.now());
				transaction.setValor(new BigDecimal(200));
				transaction.setAccount(account);
				entityManager.persist(transaction);
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
