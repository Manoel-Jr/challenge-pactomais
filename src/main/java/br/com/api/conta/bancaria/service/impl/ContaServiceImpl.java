package br.com.api.conta.bancaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.conta.bancaria.core.ConvertService;
import br.com.api.conta.bancaria.dto.ContaDTO;
import br.com.api.conta.bancaria.entity.Conta;
import br.com.api.conta.bancaria.enums.TipoContaEnum;
import br.com.api.conta.bancaria.exception.ContaExistenteException;
import br.com.api.conta.bancaria.exception.ContaNaoEncontradaException;
import br.com.api.conta.bancaria.exception.ContaNaoPossuiLimiteException;
import br.com.api.conta.bancaria.exception.SaldoInsuficienteException;
import br.com.api.conta.bancaria.repository.ContaRepository;
import br.com.api.conta.bancaria.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ConvertService convertService;

	@Override
	public ContaDTO criar(Conta conta) {
		return validarConta(conta);
	}

	private ContaDTO validarConta(Conta conta) {
		if (!contaRepository.existsByAgenciaAndNumeroConta(conta.getAgencia(), conta.getNumeroConta())) {
			if (conta.getTipoConta().equals(TipoContaEnum.CORRENTE)) {
				conta.setLimite(900);
				return convertService.converterParaContaDTO(contaRepository.save(conta));
			}
			if (conta.getTipoConta().equals(TipoContaEnum.POUPANCA)) {
				return convertService.converterParaContaDTO(contaRepository.save(conta));
			}
		}
		throw new ContaExistenteException();
	}

	@Override
	public ContaDTO consultar(String agencia, String numeroConta) {
		Conta conta = contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
		if (conta != null) {
			ContaDTO contaDTO = convertService.converterParaContaDTO(conta);
			return contaDTO;
		}
		throw new ContaNaoEncontradaException();
	}

	public void saque(String agencia, String numeroConta, double valor) {
		Conta conta = contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
		if (conta.getSaldo() < valor && conta.getLimite() < valor
				&& conta.getTipoConta().equals(TipoContaEnum.CORRENTE)) {
			throw new SaldoInsuficienteException();
		}
		conta.setSaldo(conta.getSaldo() - valor);
		convertService.converterParaContaDTO(contaRepository.save(conta));
	}

	@Override
	public double consultarSaldo(String agencia, String numeroConta) {
		ContaDTO conta = consultar(agencia, numeroConta);
		return conta.getSaldo();
	}

	@Override
	public void deposito(String agencia, String numeroConta, double valor) {
		Conta conta = contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
		conta.setSaldo(conta.getSaldo() + valor);
		convertService.converterParaContaDTO(contaRepository.save(conta));
	}

	@Override
	public double consultarLimite(String agencia, String numeroConta) {
		ContaDTO conta = consultar(agencia, numeroConta);
		if (conta.getTipoConta().equals(TipoContaEnum.POUPANCA)) {
			conta.setLimite(0);
			throw new ContaNaoPossuiLimiteException();
		}
		return conta.getLimite();

	}

	public double calcularJurosMensal(String agencia, String numeroConta, double juros) {
		ContaDTO contaDTO = consultar(agencia, numeroConta);
		if (contaDTO.getTipoConta().equals(TipoContaEnum.POUPANCA)) {
			contaDTO.setSaldo(contaDTO.getSaldo() * juros);
			return contaDTO.getSaldo();
		}
		if (contaDTO.getTipoConta().equals(TipoContaEnum.CORRENTE) && contaDTO.getSaldo() == 0) {
			contaDTO.setSaldo(contaDTO.getSaldo() * juros);
			return contaDTO.getSaldo();
		}
		return 0;

	}
}
