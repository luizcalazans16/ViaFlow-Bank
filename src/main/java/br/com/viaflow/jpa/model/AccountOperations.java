package br.com.viaflow.jpa.model;

import java.math.BigDecimal;

public class AccountOperations{
	int result;
	
	public Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

//	public void saca(Account account, double value) {
//		BigDecimal v = BigDecimal.valueOf(value).setScale(2);
//		result = super.saldo.compareTo(v);
//		if (this.result == 0 || this.result == 1) {
//			super.saldo.subtract(v);
//
//		} else {
//			throw new SaldoInsuficienteException("Saldo: " + super.saldo + "Valor: " + value);
//		}
//
//	}

	public void deposita(Account account, double value) {
		BigDecimal v = BigDecimal.valueOf(value).setScale(2);
		System.out.println(String.format("Efetuando depósito de R$ %s", v.toString().replace(".", ",")));
		account.setSaldo(account.saldo.add(v)); 
		System.out.println(account.getSaldo());
	}

}
