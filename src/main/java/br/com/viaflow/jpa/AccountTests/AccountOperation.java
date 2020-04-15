package br.com.viaflow.jpa.AccountTests;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.com.viaflow.jpa.model.Account;
import br.com.viaflow.jpa.model.AccountOperations;

public class AccountOperation {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VFBank");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {

		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a WHERE a.agency = 1234 and a.accountNumber = 5464", Account.class);
		List<Account> accountDeposit = query.getResultList();

		if (accountDeposit != null) {
			Long a = null;
			for (Account account : accountDeposit) {
				a = account.getId();
			}
			Account account = entityManager.find(Account.class, a);
			account.deposita(290);

			entityManager.getTransaction().begin();
			entityManager.merge(account);
			entityManager.getTransaction().commit();
			entityManager.close();
		} else {
			System.out.println("conta ou agência inválida");
		}
	}

}
