package br.com.api.conta.bancaria.service;

import br.com.api.conta.bancaria.dto.ContaDTO;
import br.com.api.conta.bancaria.entity.Conta;

public interface ContaService {

	public ContaDTO criar(Conta conta);

	public ContaDTO consultar(String agencia, String numeroConta);

	public void saque(String agencia,String numeroConta, double valor);

	public double consultarSaldo(String agencia, String numeroConta);
	
	public void deposito(String agencia,String numeroConta, double valor);
	
	public double consultarLimite(String agencia, String numeroConta);
	
	public double calcularJurosMensal(String agencia, String numeroConta, double juros);
}
