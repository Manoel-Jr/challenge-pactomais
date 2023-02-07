package br.com.api.conta.bancaria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.conta.bancaria.dto.ContaDTO;
import br.com.api.conta.bancaria.entity.Conta;
import br.com.api.conta.bancaria.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaRest {

	@Autowired
	private ContaService contaService;

	@PostMapping("/cadastrar-conta-corrente")
	public ResponseEntity<ContaDTO> cadastrarContaCorrente(@RequestBody Conta conta) {
		return new ResponseEntity<>(contaService.criar(conta), HttpStatus.CREATED);
	}

	@PostMapping("/cadastrar-conta-poupanca")
	public ResponseEntity<ContaDTO> cadastrarContaPoupanca(@RequestBody Conta conta) {
		return new ResponseEntity<>(contaService.criar(conta), HttpStatus.CREATED);
	}

	@GetMapping("/consultar-conta/{agencia}/{numeroConta}")
	public ResponseEntity<ContaDTO> consultarConta(@PathVariable String agencia, String numeroConta) {
		return new ResponseEntity<>(contaService.consultar(agencia, numeroConta), HttpStatus.OK);
	}

	@PostMapping("/saque/{agencia}/{numeroConta}/")
	public ResponseEntity<String> saques(@PathVariable String agencia, String numeroConta, double valor) {
		ContaDTO conta = contaService.consultar(agencia, numeroConta);
		contaService.saque(conta.getAgencia(), conta.getNumeroConta(), valor);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Saque realizado com sucesso!");
	}

	@GetMapping("/consultar-saldo/{agencia}/{numeroConta}/")
	public ResponseEntity<Double> consultarSaldo(@PathVariable String agencia, @PathVariable String numeroConta) {
		Double saldo = contaService.consultarSaldo(agencia, numeroConta);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(saldo);
	}

	@PostMapping("/deposito/{agencia}/{numeroConta}/")
	public ResponseEntity<String> deposito(@PathVariable String agencia, String numeroConta, double valor) {
		ContaDTO conta = contaService.consultar(agencia, numeroConta);
		contaService.deposito(conta.getAgencia(), conta.getNumeroConta(), valor);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deposito realizado com sucesso!");
	}

	@GetMapping("/consultar-limite/{agencia}/{numeroConta}/")
	public ResponseEntity<Double> consultarLimite(@PathVariable String agencia, @PathVariable String numeroConta) {
		Double limite = contaService.consultarLimite(agencia, numeroConta);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(limite);
	}
	
	@GetMapping("/calcular-juros-mensal/{agencia}/{numeroConta}/")
	public ResponseEntity<Double> calcularJuros(@PathVariable String agencia, @PathVariable String numeroConta, double juros) {
		Double limite = contaService.calcularJurosMensal(agencia, numeroConta, juros);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(limite);
	}
}
