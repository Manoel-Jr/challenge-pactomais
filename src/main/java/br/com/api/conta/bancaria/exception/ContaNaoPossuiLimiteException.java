package br.com.api.conta.bancaria.exception;

public class ContaNaoPossuiLimiteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaNaoPossuiLimiteException(String message) {
		super(message);
	}

	public ContaNaoPossuiLimiteException() {

	}
}
