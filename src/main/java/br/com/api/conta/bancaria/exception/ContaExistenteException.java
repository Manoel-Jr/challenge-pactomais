package br.com.api.conta.bancaria.exception;

public class ContaExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaExistenteException(String message) {
		super(message);
	}

	public ContaExistenteException() {

	}
}
