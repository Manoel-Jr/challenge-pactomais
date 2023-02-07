package br.com.api.conta.bancaria.exception.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.api.conta.bancaria.exception.ContaExistenteException;
import br.com.api.conta.bancaria.exception.ContaNaoEncontradaException;
import br.com.api.conta.bancaria.exception.ContaNaoPossuiLimiteException;
import br.com.api.conta.bancaria.exception.SaldoInsuficienteException;
import br.com.api.conta.bancaria.exception.StandarError;
import br.com.api.conta.bancaria.utils.Constantes;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<StandarError> saldoInsuficiente(SaldoInsuficienteException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.SALDO_INSUFICIENTE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ContaExistenteException.class)
	public ResponseEntity<StandarError> contaExistente(ContaExistenteException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CONTA_EXISTENTE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ContaNaoEncontradaException.class)
	public ResponseEntity<StandarError> contaExistente(ContaNaoEncontradaException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				Constantes.CONTA_NAO_ENCONTRADA, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@ExceptionHandler(ContaNaoPossuiLimiteException.class)
	public ResponseEntity<StandarError> contaExistente(ContaNaoPossuiLimiteException ex, HttpServletRequest request) {
		StandarError error = new StandarError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				Constantes.CONTA_NAO_POSSUI_LIMITE, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
