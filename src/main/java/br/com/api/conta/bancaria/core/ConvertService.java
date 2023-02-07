package br.com.api.conta.bancaria.core;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.conta.bancaria.dto.ContaDTO;
import br.com.api.conta.bancaria.dto.CorrentistaDTO;
import br.com.api.conta.bancaria.entity.Conta;
import br.com.api.conta.bancaria.entity.Correntista;

@Service
public class ConvertService {

	@Autowired
	private ModelMapper mapper;

	public CorrentistaDTO converterParaDTOSalvarCorrentista(Correntista correntista) {
		CorrentistaDTO conta = mapper.map(correntista, CorrentistaDTO.class);
		return conta;
	}
	
	public Conta converterParaConta(ContaDTO contaDTO) {
		Conta conta = mapper.map(contaDTO, Conta.class);
		return conta;
	}

	public ContaDTO converterParaContaDTO(Conta conta) {
		ContaDTO contaDTO = mapper.map(conta, ContaDTO.class);
		return contaDTO;
	}
}
