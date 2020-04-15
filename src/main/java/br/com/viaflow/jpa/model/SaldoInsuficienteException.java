package br.com.viaflow.jpa.model;

public class SaldoInsuficienteException extends RuntimeException {
	
	public SaldoInsuficienteException(String msg) {
	    super(msg);
	    }
}
