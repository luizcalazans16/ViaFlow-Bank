package br.com.viaflow.jpa.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer agency;
	private Integer accountNumber;
	protected BigDecimal saldo;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@JoinColumn(unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public void saca(double value) throws Exception {
		BigDecimal v = BigDecimal.valueOf(value).setScale(2);
		int result = this.saldo.compareTo(v);
		if (result == -1) {
			throw new Exception("Saldo insuficiente! Você possui R$ " + this.saldo + " disponíveis para saque.");
		} else {
			this.saldo = this.saldo.subtract(v);
		}
	}

	public void deposita(double value) throws Exception {
		BigDecimal v = BigDecimal.valueOf(value).setScale(2);
		
		if(v.compareTo(BigDecimal.ZERO) == 0) {
			throw new Exception("Valor inválido");
		}else {
		this.saldo = this.saldo.add(v); 
		}
	}

	
	public void transfere(double value, Account destino) throws Exception {
		BigDecimal v = BigDecimal.valueOf(value).setScale(2);
		boolean testAccount = destino.accountType.equals(AccountType.Salario);
		int result2 = this.saldo.compareTo(v);
		if(result2 == -1) {
			throw new Exception("Saldo insuficiente! Você possui R$ " + this.saldo + " disponíveis");
		}
		else if(testAccount == true) {
			throw new Exception("Não é permitido realizar transferências para uma conta salário");
		} else {
			this.saldo = this.saldo.subtract(v);
			destino.saldo = destino.saldo.add(v);}
		}
		
	}


