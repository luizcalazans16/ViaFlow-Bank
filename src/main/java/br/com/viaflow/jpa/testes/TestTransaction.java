package br.com.viaflow.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.SaldoInsuficienteException;
import br.com.viaflow.jpa.model.Transaction;
import br.com.viaflow.jpa.model.TransactionType;

public class TestTransaction {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		TypedQuery<Account> query = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 5464", Account.class);
		Account accountOrigin = query.getSingleResult();

		TypedQuery<Account> query2 = entityManager
				.createQuery("SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 4789", Account.class);
		Account accountDestiny = query2.getSingleResult();

		Transaction transaction = new Transaction();
		Transaction transaction2 = new Transaction();

		System.out.println("Saldo conta 1: " + accountOrigin.getSaldo());
		System.out.println("Saldo conta 2: " + accountDestiny.getSaldo());

		if (accountOrigin != null && accountDestiny != null) {
			entityManager.getTransaction().begin();
			try {
				accountOrigin.transfere(50, accountDestiny);

				transaction.setDescricao("Transferência");
				transaction.setTransactionType(TransactionType.Debito);
				transaction.setData(LocalDateTime.now());
				transaction.setValor(new BigDecimal(100));
				transaction.setAccount(accountOrigin);

				transaction2.setDescricao("Transferência");
				transaction2.setTransactionType(TransactionType.Credito);
				transaction2.setData(LocalDateTime.now());
				transaction2.setValor(new BigDecimal(100));
				transaction2.setAccount(accountDestiny);

				System.out.println("Novo saldo conta 1: " + accountOrigin.getSaldo());
				System.out.println("Novo saldo conta 2: " + accountDestiny.getSaldo());
			} catch (SaldoInsuficienteException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			entityManager.persist(accountOrigin);
			entityManager.persist(accountDestiny);
			entityManager.persist(transaction);
			entityManager.persist(transaction2);
			entityManager.getTransaction().commit();
			entityManager.close();
		}

	}
}
